USE DB_Project;

/*SELECT  COURSE.Course_name, COUNT(COURSE.Course_name)
FROM ENROLLS,USERS,COURSE,STUDENT_ACCOUNT
WHERE USERS.User_ID=STUDENT_ACCOUNT.User_ID
AND STUDENT_ACCOUNT.Student_ID=ENROLLS.Student_ID
AND ENROLLS.Course_ID=COURSE.Course_ID
AND COURSE.Course_name='Algoritma 1'
GROUP BY COURSE.Course_name  */

-- select max (DATEDIFF (year,StartDate,EndDate)) from EXPERIENCE

SELECT *
FROM POST, TAG, BELONGS_TO
WHERE TAG.Tag_ID=BELONGS_TO.Tag_ID AND
      POST.Post_ID=BELONGS_TO.Post_ID AND
      POST.Post_Text='Hepinizle çalışmaktan mutluluk duyuyorum.' AND TAG.Followers>4