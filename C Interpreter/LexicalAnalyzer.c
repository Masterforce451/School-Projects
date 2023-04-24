#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

int keywords(char array[]) { //checks if the string is a keyword
    if ((strcmp("int", array) == 0 || strcmp("move", array) == 0 || strcmp("to", array) == 0 || strcmp("loop", array) == 0 || strcmp("times", array) == 0 ||
        strcmp("out", array) == 0 || strcmp("newline", array) == 0 || strcmp("add", array) == 0 || strcmp("out", array) == 0 || strcmp("sub", array) == 0)) 
        return 1; 
    else return 0; 
}

int is_valid(char letter) { //checks if the letter is a valid character
    if (letter == 33 || letter == 34 || letter == 35 || letter == 36 || letter == 37 || letter == 38 || letter == 39 || letter == 40 || letter == 41 ||
        letter == 42 || letter == 47 || letter == 58 || letter == 59 || letter == 60 || letter == 61 || letter == 62 || letter == 63 || letter == 64 || 
        letter == 94) 
        return 1; 
    else return 0;
}

int end_line_check(FILE* lx_file,int line_end,int line_count) { //checks if it's end of line or not
    if (line_end == 1) {
        fprintf(lx_file, "EndOfLine\n");
        line_end = 0; }
    else if (line_end == -1) {
        fprintf(lx_file, "End of line character (.) was not found in line %d.\n", line_count - 1);
        line_end = 0; 
    }
    return 0;
}

int space_check(char character) { //checks space characters
    if (character == ' ' || character == '\n' || character == '\t' || character == '\v' || character == '\f' || character == '\r')
           return 1; 
    else { return 0; } 
}

int main() {
    FILE* ba_file;
    char ba_file_name[20];
    char lx_file_name[20];
    char character;
    int i = 0, word_length = 0, j = 0, line_count = 1, line_end = 0, comment_check = 0, number_error = 0;
    bool invalid = false; //invalid character 

    printf("Enter the file name:");
    scanf("%s",ba_file_name);
    strcpy(lx_file_name,ba_file_name);

    strcat(ba_file_name,".ba");
    strcat(lx_file_name, ".lx");

    ba_file = fopen(ba_file_name, "r"); //ba file is opening
    if (ba_file == NULL) 
        printf("Could not open the file.!\n");
    else {
        FILE* lx_file;
        lx_file = fopen(lx_file_name, "w");
        character = getc(ba_file);

        while (character != EOF) { // loop for until we see end of the file
            char string[101] = { '\0' };
            if ((character >= 48 && character <= 57)) {
                i = -1;
                string[++i] = character;
                character = getc(ba_file);
                while ((character >= 48 && character <= 57) && character != '\n') { //gets the number and check if it's larger than
                    if (string[99] == '\0') {                                       //100 digits or not
                        string[++i] = character;
                        character = getc(ba_file);
                    } 
                    else {
                        number_error = 1;
                        while (!space_check(character) && character != '.')
                            character = getc(ba_file);
                        break;
                    }
                }
                if (!((string[0] >= 65 && string[0] <= 90) || (string[0] >= 97 && string[0] <= 122)) && 
                     ((character >= 65 && character <= 90) || (character >= 97 && character <= 122)) > 0) {
                     fprintf(lx_file, "Error in line %d. Variable names must start with letter.\n", line_count);
                }
                string[i+1] = '\0';
                if (character == '\n' || character == '\r')
                    line_count++;
                for (int j = 0; j < i + 1; j++) {
                    if (string[j] == '.') {
                        number_error = 1;
                        break;
                    }
                }
                if (number_error == 1) { //if the number is longer than 100 digits or has a floating point
                    fprintf(lx_file, "Invalid number in line %d.\n", line_count); 
                    number_error = 0;
                }
                else {
                    fprintf(lx_file, "IntConstant %s\n", string); 
                }
            }
            if (((character >= 65 && character <= 90) || (character >= 97 && character <= 122)) || character == '{' || character == '}') {
                i = 0;
                if (character == '{') { //comment started
                    comment_check = 1;
                    character = getc(ba_file);
                    while (character != '}') {
                        while (1) { //loop for until the comment is closed
                            if (character == '}') {
                                comment_check = 0;
                                break;
                            }
                            if (character == EOF) {
                                break;
                            }
                            character = getc(ba_file);
                        }
                        if (character == '\n' || character == '\r') {
                            line_count++;
                            character = getc(ba_file);
                        }
                        if (character == EOF) { fprintf(lx_file,"\nUnclosed paranthesis with end of file.\n");
                            exit(0);
                        }
                    }
                    character = getc(ba_file);
                    continue;
                } else if (comment_check != 0 && character == '}') {
                    if (character == '}') { fprintf(lx_file, "Closed paranthesis without opening it in line %d.\n", line_count);}
                    character = getc(ba_file);
                }
                string[i++] = character;
                character = getc(ba_file);
                word_length = 1;
                while (((character >=65 && character <= 90) || (character >= 97 && character <= 122)) && character != '.' || 
                         character == '_' || (character >=48 && character <=57) || character < -1) {  
                    while (character < -1) { //ba file has invalid character
                        invalid = true;
                        string[i++] = character;
                        character = getc(ba_file);
                        word_length++;
                    }
                    word_length++;
                    string[i++] = character;
                    character = getc(ba_file);
                }
                string[i] = '\0';
                if (word_length > 20) {
                    fprintf(lx_file, "Error in line %d. Words must not be longer than 20 letters.\n", line_count);
                    continue;
                }
                if (character == '.') {
                    character = getc(ba_file);
                    line_end = 1;
                }
                else if (character == '\n' || character == '\r') {
                    line_count++;
                    character = getc(ba_file);
                    line_end = -1;
                }
                if (strcmp("times", string) == 0)
                    line_end = 0;
                if (strcmp("out", string) == 0) {
                    character = getc(ba_file);
                    while (space_check(character)) {
                        character = getc(ba_file);
                    }
                    string[i] = '\0';
                    fprintf(lx_file, "Keyword %s\n", string);
                    end_line_check(lx_file, line_end, line_count);
                    line_end = 0;
                    continue;
                }
                else if (keywords(string) == 1) {
                    if (character != '}') {
                        fprintf(lx_file, "Keyword %s\n", string);
                    }
                    end_line_check(lx_file, line_end, line_count);
                    line_end = 0;
                    continue;
                }
                else {
                    if (string[0] != '\n') {
                        if (invalid == false) {
                            fprintf(lx_file, "Identifier %s\n", string);
                        } else {
                            fprintf(lx_file, "Invalid character found identifier %s in line %d\n", string,line_count);
                            invalid = false;
                        }
                    }
                    end_line_check(lx_file, line_end, line_count);        
                    if (character == -1 && line_end == 0) {
                        fprintf(lx_file, "End of line character (.) was not found in line %d.\n", line_count);
                    }
                    line_end = 0;
                    continue;
                }
            }
            if (character == '"') { //String constant part
                i = 0;
                string[i++] = character;
                character = getc(ba_file);
                while (character != '"' && character != EOF) { //loop until we see another " or end of file
                    string[i++] = character;
                    character = getc(ba_file);
                }
                if (getc(ba_file) == EOF && character != '"') {
                    fprintf(lx_file, "Undefined string constant in line %d.\n", line_count);
                    exit(0);
                }
                if (character == 46) {
                    fprintf(lx_file, "EndOfLine\n");
                    character = getc(ba_file + 1);
                    character = getc(ba_file);
                    if (character == '\n' || character == '\r')
                        line_count++;
                }
                if (character == '"') {
                    string[i++] = character;
                    string[i] = '\0';
                    fprintf(lx_file, "StringConstant %s\n", string);
                }
                character = getc(ba_file);
                continue;
            }       
            if (is_valid(character)) {
                fprintf(lx_file, "Invalid character in line %d.\n", line_count);
                character = getc(ba_file);
                continue;
            }
            if (space_check(character) && character != '.') {
                if (character == '\n' || character == '\r')
                    line_count++;
                character = getc(ba_file);
                while (space_check(character) && character != '.') {
                    if (character == '\n' || character == '\r')
                        line_count++;
                    character = getc(ba_file);
                }
                if (character == '.') {
                    fprintf(lx_file, "EndOfLine\n");
                    character = getc(ba_file);
                    if (character == '\n' || character == '\r')
                    line_count++;
                }
                continue;
            }
            if (character == ',') {
                fprintf(lx_file, "Seperator\n");
                character = getc(ba_file);
                continue;
            }
            if (character == '\n' || character == '\r')
                line_count++;
            if (character == '-') {
                fprintf(lx_file, "Minus sign\n");
                character = getc(ba_file);
                if (!(character >= 48 && character <= 57)) {
                    fprintf(lx_file, "Error in line %d. After the minus operator, only numbers are allowed.\n", line_count);
                }
                continue;
            }
            if (character == '+') {
                character = getc(ba_file);
                if (!(character >= 48 && character <= 57)) {
                    fprintf(lx_file, "Error in line %d. Plus operator is not allowed.\n", line_count);
                }
                continue;
            }
            if (character == '[') {
                fprintf(lx_file, "OpenBlock\n");
                character = getc(ba_file);
                if (character == '\n' || character == '\r')
                    line_count++;
                continue;
            }
            if (character != '.') {
                if (space_check(character)) {
                    while (space_check(character)) {
                        if (character == '\n' || character == '\r')
                            line_count++;
                        character = getc(ba_file);
                    }
                }
            }
            if (character == ']') {
                fprintf(lx_file, "CloseBlock\n");
                character = getc(ba_file);
                if (character == '\n' || character == '\r') {
                    line_count++;
                    character = getc(ba_file);
                }
                continue;
            }
        }
        fclose(ba_file); //and then we close the files
        fclose(lx_file);
    }
    return 0;
}