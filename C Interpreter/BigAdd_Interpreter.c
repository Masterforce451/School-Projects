#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
/*
int keywords(char array[]) { //checks if the string is a keyword
    if (strcmp("int", array) == 0 || strcmp("move", array) == 0 || strcmp("to", array) == 0 || strcmp("loop", array) == 0 || strcmp("times", array) == 0 ||
        strcmp("out", array) == 0 || strcmp("newline", array) == 0 || strcmp("add", array) == 0 || strcmp("sub", array) == 0 || strcmp("from",array) == 0)
        return 1;
    else return 0;
}

int is_invalid(char letter) { //checks if the letter is a valid character
    if (letter == 33 || letter == 34 || letter == 35 || letter == 36 || letter == 37 || letter == 38 || letter == 39 || letter == 40 || letter == 41 ||
        letter == 42 || letter == 47 || letter == 58 || letter == 59 || letter == 60 || letter == 61 || letter == 62 || letter == 63 || letter == 64 ||
        letter == 94)
        return 1;
    else return 0;
}

int end_line_check(FILE* lx_file, int line_end, int line_count) { //checks if it's end of line or not
    if (line_end == 1) {
        fprintf(lx_file, "EndOfLine\n");
        line_end = 0;
    }
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

void substring(char s[], char sub[], int p, int l) {
    int c = 0;
    while (c < l) {
        sub[c] = s[p + c - 1];
        c++;
    }
    while (sub[c] != '\0') {
        sub[c++] = '\0';
    }
}

FILE* lx_file = NULL;
char line[200];
char word[100];
char variable_list[10][20];
int variable_values[10];
int variable_index = 0, temp = 0;
bool dosya_bitti = false;
bool line_ended;
bool undeclared_variable = true;
bool in_a_loop = false;
bool is_identifier;
int loop_times[10];
int loop_counter = -1;
char loop_lines[100][200];
int line_index = 0;
int line_counter = 0;
int open_block_counter = 0;
int loop_border_lines[10][2];


get_line(char armut[]) {
    if (!in_a_loop) {
        fgets(armut, 200, lx_file);
    }
    else {
        strcpy(armut, loop_lines[line_counter+1]);
    }
    line_counter++;
}

void func_loop() {
    int variable_i = -1;
    char line_of_loop[200];
    char* token;
    loop_counter++;
    bool undeclared_indentifier = true;
    loop_border_lines[0][0] = 0;
    fgets(line_of_loop, 200, lx_file);

    token = strtok(line_of_loop, " ");
    if (strcmp(token, "Identifier") == 0) {
        is_identifier = true;
        token = strtok(NULL, " ");
        substring(token, token, 1, strlen(token) - 1);
        for (int i = 0;i < 10; i++) {        
            if (strcmp(token, variable_list[i]) == 0) {
                loop_times[loop_counter] = variable_values[i];
                variable_i = i;
                undeclared_indentifier = false;
                break;
            }
        }
        if (undeclared_indentifier) {
            printf("Undeclared identifier.");
            exit(0);
        }
    }
    else if (strcmp(token, "IntConstant") == 0) {
        is_identifier = false;
        token = strtok(NULL, " ");
        loop_times[loop_counter] = atoi(token);
    }

    fgets(line_of_loop, 200, lx_file);
    if (strcmp(line_of_loop, "Keyword times\n") != 0) {
        printf("Loop statement must end with keyword 'times'");
        exit(0);
    }
    fgets(line_of_loop, 200, lx_file);
    if (strcmp(line_of_loop, "OpenBlock\n") != 0) {
        printf("Loop statement must be used with an 'OpenBlock'");
        exit(0);
    }
    else if (strcmp(line_of_loop, "OpenBlock\n") == 0) {
        open_block_counter++;
    }

    while (open_block_counter != 0) {
        fgets(line_of_loop, 200, lx_file);
        if (strcmp(line_of_loop, "CloseBlock\n") == 0) {
            strcpy(loop_lines[line_index++], line_of_loop);
            open_block_counter--;
            loop_border_lines[loop_counter][1] = line_counter;
            continue;
        }

        if (strcmp(line_of_loop, "Keyword loop\n") == 0) {
            loop_border_lines[loop_counter+1][0] = line_counter-1;
            func_loop(lx_file);
        }
        else {
            strcpy(loop_lines[line_index++], line_of_loop);
        }
    }
    line_counter = loop_border_lines[loop_counter][0];
    while (loop_times[loop_counter] > 0) {
        if (variable_i != -1) {
            variable_values[variable_i] = loop_times[loop_counter];
        }
        substring(loop_lines[line_counter], word, 1, 7);
        if (strcmp(word, "Keyword") == 0) {
            substring(loop_lines[line_counter], word, 9, strlen(line_of_loop) - 8);

            if (strcmp(word, "int") == 0) {
                in_a_loop = true;
                func_declaration();
            }
            else if (strcmp(word, "move") == 0 || strcmp(word, "move\n") == 0) {
                in_a_loop = true;
                func_move();
            }
            else if (strcmp(word, "add") == 0 || strcmp(word, "add\n") == 0) {
                in_a_loop = true;
                func_add();
            }
            else if (strcmp(word, "sub") == 0 || strcmp(word, "sub\n") == 0) {
                in_a_loop = true;
                func_sub();
            }
            else if (strcmp(word, "out") == 0 || strcmp(word, "out\n") == 0) {
                in_a_loop = true;
                func_out();
            }
            else if (strcmp(word, "loop") == 0 || strcmp(word, "loop\n") == 0) {
                in_a_loop = true;
                func_loop();
            }
        }    
        else if (strcmp(word, "EndOfLi") == 0) {
            line_counter++;
        }
        else if (strcmp(word, "CloseBl") == 0) {
            line_counter = loop_border_lines[loop_counter][0];
            loop_times[loop_counter]--;
            variable_i = 0;
            if (is_identifier) {
                variable_values[variable_i] = loop_times[loop_counter];
            }
            variable_i = -1;       

        }
    }

    in_a_loop = false;
    memset(line, -52, 200);
    char keywo[20] = "Keywo";
    fgets(line, 200, lx_file);
    if (line[0] == 'r' && line[1] == 'd') {
        strcat(keywo,line);
        strcpy(line,keywo);
    }
    loop_counter--;
}

func_declaration() {
    get_line(line);
    substring(line, word, 1, 10);
    if (strcmp(word, "Identifier") == 0) {
        substring(line, word, 12, strlen(line) - 12);
        for (int i = 0;i < 10;i++) {
            if (strcmp(variable_list[i], word) == 0) {
                printf("Variables can not be declared more than once.");
                exit(0);
            }
        }
        strcpy(variable_list[variable_index], word);
        variable_values[variable_index++] = 0;
        get_line(line);
        if (strcmp(line, "EndOfLine\n") == 0) {
            line_ended = true;
            get_line(line);
            if (strcmp(line, "EndOfLine\n") == 0)
                dosya_bitti = true;
        }
    }
}

func_move() {
    bool neg_number = false;
    get_line(line);
    substring(line, word, 1, 11);
    if (strcmp(word, "IntConstant") == 0 || strcmp(word, "Identifier ") == 0 || strcmp(word,"Minus sign\n") == 0) {
        if (strcmp(word, "IntConstant") == 0 || strcmp(word, "Minus sign\n") == 0) {
            if (strcmp(word, "Minus sign\n") == 0) {
                neg_number = true;
                get_line(line);
            }
            substring(line, word, 13, strlen(line) - 13);
            temp = atoi(word);
            if (neg_number == true)
                temp *= -1;
        }
        else {
            substring(line, word, 12, strlen(line) - 12);
            for (int i = 0; i < 10; i++) {
                if (strcmp(variable_list[i], word) == 0) {
                    temp = variable_values[i];
                    undeclared_variable = false;
                    break;
                }
            }
            if (undeclared_variable) {
                printf("Undeclared variable in line.");
                exit(0);
            }
        }
        get_line(line);
        substring(line, word, 1, 7);
        if (strcmp(word, "Keyword") == 0) {
            substring(line, word, 9, strlen(line) - 9);
            if (strcmp(word, "to") == 0) {
                get_line(line);
                substring(line, word, 1, 10);
                if (strcmp(word, "Identifier") == 0) {
                    substring(line, word, 12, strlen(line) - 12);
                    for (int i = 0; i < 10; i++) {
                        if (strcmp(variable_list[i], word) == 0) {
                            variable_values[i] = temp;
                            undeclared_variable = false;
                            break;
                        }
                    }
                    if (undeclared_variable) {
                        printf("Undeclared variable in line.");
                        exit(0);
                    }
                    get_line(line);
                    if (strcmp(line, "EndOfLine\n") == 0) {
                        line_ended = true;
                        get_line(line);
                        if (strcmp(line, "EndOfLine\n") == 0)
                            dosya_bitti = true;
                    }
                }
            }
        }
    }
}

func_add() {
    bool neg_number = false;
    get_line(line);
    substring(line, word, 1, strlen(line)-5);
    if (strcmp(word, "IntConstant") == 0 || strcmp(word, "Identifier ") == 0 || strcmp(word, "Minus sign\n") == 0) {
        if (strcmp(word, "IntConstant") == 0 || strcmp(word, "Minus sign\n") == 0) {
            if (strcmp(word, "Minus sign\n") == 0) {
                neg_number = true;
                get_line(line);
            }
            substring(line, word, 13, strlen(line) - 13);
            temp = atoi(word);
            if (neg_number == true)
                temp *= -1;
        }
        else {
            substring(line, word, 12, strlen(line) - 12);
            for (int i = 0; i < 10; i++) {
                if (strcmp(variable_list[i], word) == 0) {
                    temp = variable_values[i];
                    undeclared_variable = false;
                    break;
                }
            }
            if (undeclared_variable) {
                printf("Undeclared variable in line.");
                exit(0);
            }
        }
        get_line(line);
        substring(line, word, 1, 7);
        if (strcmp(word, "Keyword") == 0) {
            substring(line, word, 9, strlen(line) - 9);
            if (strcmp(word, "to") == 0) {
                get_line(line);
                substring(line, word, 1, 10);
                if (strcmp(word, "Identifier") == 0) {
                    substring(line, word, 12, strlen(line) - 12);
                    for (int i = 0; i < 10; i++) {
                        if (strcmp(variable_list[i], word) == 0) {
                            variable_values[i] += temp;
                            undeclared_variable = false;
                            break;
                        }
                    }
                    if (undeclared_variable) {
                        printf("Undeclared variable in line.");
                        exit(0);
                    }
                    get_line(line);
                    if (strcmp(line, "EndOfLine\n") == 0) {
                        line_ended = true; 
                        get_line(line);
                        if (strcmp(line, "EndOfLine\n") == 0)
                            dosya_bitti = true;
                    }
                }
            }
        }
    }
}

func_sub() {
    bool neg_number = false;
    get_line(line);
    substring(line, word, 1, 11);
    if (strcmp(word, "IntConstant") == 0 || strcmp(word, "Identifier ") == 0 || strcmp(word, "Minus sign\n") == 0) {
        if (strcmp(word, "IntConstant") == 0 || strcmp(word, "Minus sign\n") == 0) {
            if (strcmp(word, "Minus sign\n") == 0) {
                neg_number = true;
                get_line(line);
            }
            substring(line, word, 13, strlen(line) - 13);
            temp = atoi(word);
            if (neg_number == true)
                temp *= -1;
        }
        else {
            substring(line, word, 13, strlen(line) - 13);
            for (int i = 0; i < 10; i++) {
                if (strcmp(variable_list[i], word) == 0) {
                    temp = variable_values[i];
                    undeclared_variable = false;
                    break;
                }
            }
            if (undeclared_variable) {
                printf("Undeclared variable in line.");
                exit(0);
            }
        }
        get_line(line);
        substring(line, word, 1, 7);
        if (strcmp(word, "Keyword") == 0) {
            substring(line, word, 9, strlen(line) - 9);
            if (strcmp(word, "from") == 0) {
                get_line(line);
                substring(line, word, 1, 10);
                if (strcmp(word, "Identifier") == 0) {
                    substring(line, word, 12, strlen(line) - 12);
                    for (int i = 0; i < 10; i++) {
                        if (strcmp(variable_list[i], word) == 0) {
                            variable_values[i] -= temp;
                            undeclared_variable = false;
                            break;
                        }
                    }
                    if (undeclared_variable) {
                        printf("Undeclared variable in line.");
                        exit(0);
                    }
                    get_line(line);
                    if (strcmp(line, "EndOfLine\n") == 0) {
                        line_ended = true;
                        get_line(line);
                        if (strcmp(line, "EndOfLine\n") == 0)
                            dosya_bitti = true;
                    }
                }
            }
        }
    }
}

func_out() {
    get_line(line);
    char* token;
    int number;
    token = strtok(line, " ");
    while (strcmp(token, "EndOfLine\n") != 0) {
        if (strcmp(token, "Keyword") == 0) {
            token = strtok(NULL, " ");
            if (strcmp(token, "newline\n") == 0) {
                printf("\n");
            }
        }
        else if (strcmp(token, "IntConstant") == 0) {
            token = strtok(NULL, " ");
            number = atoi(token);
            printf("%d", number);
        }
        else if (strcmp(token, "Identifier") == 0) {
            token = strtok(NULL, " ");
            substring(token, token, 1, strlen(token) - 1);
            for (int i = 0; i < 10; i++) {
                if (strcmp(variable_list[i], token) == 0) {
                    printf("%d", variable_values[i]);
                    break;
                }
            }
        }
        else if (strcmp(token, "StringConstant") == 0) {
            token = strtok(NULL, "");
            substring(token, token, 2, strlen(token) - 3);
            printf("%s", token);
        }
        else if (strcmp(token, "Seperator\n") == 0) {
            get_line(line);
            token = strtok(line, " ");
            continue;
        }

        else if (strcmp(token, "Minus") == 0) {
            token = strtok(NULL, " ");
            if (strcmp(token, "sign\n") == 0) {
                printf("-");
            }
        }
        get_line(line);
        token = strtok(line, " ");
    }
    line_ended = true;

    char eof_check;
    eof_check = getc(lx_file);
    if (eof_check == -1)
        dosya_bitti = true;
}

int main() {

    FILE* ba_file;
    char ba_file_name[20];
    char lx_file_name[20];
    char character;
    int i = 0, word_length = 0, j = 0, line_count = 1, line_end = 0, comment_check = 0, number_error = 0;
    bool invalid = false; //invalid character 

    printf("Enter the file name:");
    scanf("%s", ba_file_name);
    strcpy(lx_file_name, ba_file_name);

    strcat(ba_file_name, ".ba");
    strcat(lx_file_name, ".lx");

    ba_file = fopen(ba_file_name, "r"); //ba file is opening
    if (ba_file == NULL)
        printf("Could not open the file.!\n");
    else {
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
                    exit(0);
                }
                string[i + 1] = '\0';
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

                if (character == '.') {
                    character = getc(ba_file);
                    line_end = 1;
                    fprintf(lx_file, "EndOfLine\n");
                    if (character == '\r') {
                        break;
                    }
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
                        if (character == EOF) {
                            fprintf(lx_file, "\nUnclosed paranthesis with end of file.\n");
                            exit(0);
                        }
                    }
                    character = getc(ba_file);
                    continue;
                }
                else if (comment_check != 0 && character == '}') {
                    if (character == '}') { fprintf(lx_file, "Closed paranthesis without opening it in line %d.\n", line_count); }
                    character = getc(ba_file);
                }
                string[i++] = character;
                character = getc(ba_file);
                word_length = 1;
                while (((character >= 65 && character <= 90) || (character >= 97 && character <= 122)) && character != '.' ||
                    character == '_' || (character >= 48 && character <= 57) || character < -1) {
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
                        }
                        else {
                            fprintf(lx_file, "Invalid character found identifier %s in line %d\n", string, line_count);
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
            if (is_invalid(character)) {
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
            if (character == '.') {
                fprintf(lx_file, "EndOfLine\n");
                character = getc(ba_file);
                continue;
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

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        lx_file = fopen(lx_file_name, "r");

        fgets(line, 200, lx_file);
        while (!dosya_bitti) {
            line_ended = false;
            while (!line_ended) {
                substring(line, word, 1, 7);
                if (strcmp(word, "Keyword") == 0) {
                    substring(line, word, 9, strlen(line) - 9);

                    if (strcmp(word, "int") == 0) {
                        func_declaration();
                    }
                    else if (strcmp(word, "move") == 0) {
                        func_move();
                    }
                    else if (strcmp(word, "add") == 0) {
                        func_add();
                    }
                    else if (strcmp(word, "sub") == 0) {
                        func_sub();
                    }
                    else if (strcmp(word, "out") == 0) {
                        func_out();
                    }
                    else if (strcmp(word, "loop") == 0) {
                        func_loop();
                    }
                }
                else {
                    printf(word);
                    printf("Invalid syntax in .ba file.");
                    exit(0);
                }
            }
        }
        fclose(lx_file);
        return 0;
    }
}*/