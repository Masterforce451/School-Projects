USE DB_PROJECT2;
/*----------------------------USERS TABLE: 2 ADMIN, 10 BASIC, 22 EMPLOYE, 6 TEACHER, 19 STUDENT, 6 ORGANIZATION --------------------------------------- */
INSERT INTO USERS 
VALUES
/*ADMIN*/
('Lee'       ,'Howell'    ,'1001','ADMIN'   ,'E2AdwpXx36UkHcz4',NULL        ,'photo_id?=1001','leewell@gmail.com'           ,'www.howell.com'         ,'Bachelor' ,'97 Baker St. Lawrence Township, NJ'           ,'M'),/*ADMIN*/
('Yasin'     ,'Humphrey'  ,'1002','ADMIN'   ,'mQNXewVB68FVJhh9','1974-06-28','photo_id?=1002','yasinrey@gmail.com'          ,'www.yasinhumprey.com'   ,'Master'   ,'7599 Summit Rd. Burbank, IL'                  ,'M'),/*ADMIN*/

/*BASIC*/
('Albert'    ,'Mcbride'   ,'2002','BASIC'   ,'nJmkGZMf2T8PJLhX','2000-02-11','photo_id?=2002','albride@gmail.com'           ,NULL                     ,'Master'   ,'2 Lake View Dr. Nashville, TN'                ,'M'),/*BASIC*/
('Taylor'    ,'Moreno'    ,'2006','BASIC'   ,'EhZt3FdYKNB6dACY','1996-02-13',NULL            ,'taylormoreno@gmail.com'      ,NULL                     ,'Master'   ,'666 Wood Rd. Deerfield Beach, FL'             ,'M'),/*BASIC*/
('Keaton'    ,'Ray'       ,'2009','BASIC'   ,'9x7jEBN5kfVhemTE','2001-11-21','photo_id?=2009','keatray@gmail.com'           ,NULL                     ,'Bachelor' ,'7170 Blue Spring St. Point Pleasant Beach, NJ','M'),/*BASIC*/
('Henry'     ,'Solis'     ,'3004','BASIC'   ,'67TxV86vGhEnB3Dv','1995-12-02',NULL            ,'henris@gmail.com'            ,NULL                     ,'Master'   ,'7290 Inverness Street Millville, NJ'          ,'M'),/*BASIC*/
('Evangeline','Powers'    ,'3006','BASIC'   ,'2sUMpd5BmPWfSwM8','1992-11-09','photo_id?=3006','evangelinepowers@gmail.com'  ,'www.evangeline.com'     ,'Bachelor' ,'9549 Hilltop Street Bellmore, NY'             ,'F'),/*BASIC*/
('Vanessa'   ,'Duncan'    ,'3009','BASIC'   ,'d8EF6r5gNkmgd2ye','1953-03-29',NULL            ,'vanesduncan@gmail.com'       ,NULL                     ,'Doctorate','3 North Linden Ave. New Britain, CT'          ,'F'),/*BASIC*/
('Bruce'     ,'Rose'      ,'5002','BASIC'   ,'5ReTcqD4MYBf5Xe4','1993-06-30','photo_id?=5002','rose@gmail.com'              ,NULL                     ,'Bachelor' ,'386 Temple Lane Raeford, NC'                  ,'M'),/*BASIC*/
('Ted'       ,'Yang'      ,'5003','BASIC'   ,'pz6q6FWN9VWQkkep','1994-07-01','photo_id?=5003','yang@gmail.com'              ,NULL                     ,'Master'   ,'260 Fairfield Street Feasterville Trevose, PA','M'),/*BASIC*/
('Betty'     ,'Owens'     ,'5004','BASIC'   ,'v5EZFANq3fnYJjSf','1990-09-09','photo_id?=5004','owens@gmail.com'             ,NULL                     ,'Bachelor' ,'7059 Thomas Rd. Orange, NJ'                   ,'F'),/*BASIC*/
('Nia'       ,'Cross'     ,'5006','BASIC'   ,'WL5F2YjMzAB45Y4k','1995-06-26','photo_id?=5006','cross@gmail.com'             ,NULL                     ,'Bachelor' ,'22 W. Halifax St. Asbury Park, NJ'            ,'F'),/*BASIC*/

/*EMPLOYEE*/
('Kira'      ,'Wilkerson' ,'1003','EMPLOYEE','u4ZuRKgAGeHa73DE',NULL        ,'photo_id?=1003','kirason@gmail.com'           ,NULL                     ,'Master'   ,'9549 Hilltop Street Bellmore, NY'             ,'M'),/*EMPLOYEE*/
('Mollie'    ,'Wood'      ,'1005','EMPLOYEE','3vs72EzMHz3yt2Da','1972-07-27',NULL            ,'molliwood@gmail.com'         ,NULL                     ,'Master'   ,'8063 Devonshire St. Malvern, PA'              ,'F'),/*EMPLOYEE*/
('Christine' ,'Carr'      ,'2005','EMPLOYEE','wy6d2L5PWNMhNdXV','1955-01-03','photo_id?=2005','chriscar@gmail.com'          ,NULL                     ,'Master'   ,'69 South Branch Dr. Kenosha, WI'              ,'F'),/*EMPLOYEE*/
('Harold'    ,'Mendez'    ,'2007','EMPLOYEE','DnJktd4BCnYjfV6q',NULL        ,'photo_id?=2007','haroldez@gmail.com'          ,NULL                     ,'Bachelor' ,'8123 Walnutwood Lane Stillwater, MN'          ,'M'),/*EMPLOYEE*/
('Scarlet'   ,'Russell'   ,'2008','EMPLOYEE','rg7k3mRsatcQMWFW','1953-05-30','photo_id?=2008','scarletll@gmail.com'         ,NULL                     ,'Bachelor' ,'637 Shore Lane Wheeling, WV'                  ,'F'),/*EMPLOYEE*/
('Joyce'     ,'Wallace'   ,'4003','EMPLOYEE','w88zBAqTw7Km4Kqs',NULL        ,'photo_id?=4003','joycewallace@gmail.com'      ,NULL                     ,'Bachelor' ,'886 Third Street San Carlos, CA'              ,'F'),/*EMPLOYEE*/
('Morgan'    ,'Norris'    ,'4004','EMPLOYEE','cD69wGknMHnEbTB4','1990-02-13','photo_id?=4004','norris@gmail.com'            ,NULL                     ,'Bachelor' ,'3 Talbot Ave.Manahawkin, NJ'                  ,'M'),/*EMPLOYEE*/
('Emelia'    ,'Johnson'   ,'4005','EMPLOYEE','8ZxETph5LJVLAute','1998-09-23','photo_id?=4005','johnson@gmail.com'           ,NULL                     ,'Bachelor' ,'505 Walnutwood St.Norfolk, VA'                ,'F'),/*EMPLOYEE*/
('Violet'    ,'Newman'    ,'4006','EMPLOYEE','4VHTtANTqm8JAcvQ','1993-10-09','photo_id?=4006','newman@gmail.com'            ,NULL                     ,'Bachelor' ,'8132 North Rock Creek Street Williamsport, PA','F'),/*EMPLOYEE*/
('Floyd'     ,'Wong'      ,'4008','EMPLOYEE','skT7puRzjByHNcUE','1990-11-27','photo_id?=4008','wong@gmail.com'              ,NULL                     ,'Bachelor' ,'9968 Monroe Road Fond Du Lac, WI'             ,'M'),/*EMPLOYEE*/
('Kara'      ,'Houston'   ,'4009','EMPLOYEE','UPPuDGnTRvQBh95Q','1995-11-23','photo_id?=4009','houston@gmail.com'           ,NULL                     ,'Bachelor' ,'8835 North Corona Circle Far Rockaway, NY'    ,'F'),/*EMPLOYEE*/
('Timothy'   ,'Nelson'    ,'5005','EMPLOYEE','eVr7azUHNywC9P5Z','1990-08-18','photo_id?=5005','nelson@gmail.com'            ,NULL                     ,'Bachelor' ,'194 North Greenrose Ave. Myrtle Beach, SC'    ,'M'),/*EMPLOYEE*/
('Aleena'    ,'Hansen'    ,'5008','EMPLOYEE','7YMdaEDCNkj4T9hy','1992-08-14','photo_id?=5008','hansen@gmail.com'            ,NULL                     ,'Bachelor' ,'600 Baker Ave. Eugene, OR'                    ,'F'),/*EMPLOYEE*/
('Jackson'   ,'Moran'     ,'5009','EMPLOYEE','pE7EcYE4KMu7hpUR','2000-08-03','photo_id?=5009','moran@gmail.com'             ,NULL                     ,'Bachelor' ,'8490 Berkshire Drive Bettendorf, IA'          ,'M'),/*EMPLOYEE*/
('Aisha'     ,'Cunningham','6002','EMPLOYEE','HDSRyfQB7SccUE3b','1994-01-23','photo_id?=6002','cunningham@gmail.com'        ,NULL                     ,'Bachelor' ,'8925 Market St. Woodstock, GA'                ,'F'),/*EMPLOYEE*/
('Lilly'     ,'Stokes'    ,'6003','EMPLOYEE','BZe9bXRTE2xgqNMf','1994-07-19','photo_id?=6003','stokes@gmail.com'            ,NULL                     ,'Bachelor' ,'715 N. Andover Street Orland Park, IL'        ,'F'),/*EMPLOYEE*/
('Shane'     ,'Klein'     ,'6004','EMPLOYEE','juJYZt436fJ6XDdL','1992-01-24','photo_id?=6004','klein@gmail.com'             ,NULL                     ,'Bachelor' ,'8626 Edgefield Court Deerfield, IL'           ,'M'),/*EMPLOYEE*/
('Shaun'     ,'Schneider' ,'6005','EMPLOYEE','dVTGSfU4g6z6ekzP','2000-03-24','photo_id?=6005','schneider@gmail.com'         ,NULL                     ,'Master'   ,'501 Andover Road Key West, FL'                ,'M'),/*EMPLOYEE*/
('Lia'       ,'Haynes'    ,'7002','EMPLOYEE','AduzbfBEg3Lcv4Zt','1999-05-06','photo_id?=7002','haynes@gmail.com'            ,NULL                     ,'Master'   ,'9359 High St. Saginaw, MI'                    ,'F'),/*EMPLOYEE*/
('Beatrice'  ,'Morton'    ,'7003','EMPLOYEE','YQ5YJ9cDrCCfJfsA','1998-07-09','photo_id?=7003','morton@gmail.com'            ,NULL                     ,'Bachelor' ,'3 Second Dr. Manchester, NH'                  ,'F'),/*EMPLOYEE*/
('Tanya'     ,'Warren'    ,'7004','EMPLOYEE','Dd8MJ3wZM3hFdxzj','2000-02-02','photo_id?=7004','warren@gmail.com'            ,NULL                     ,'Master'   ,'7560 Valley Farms Street Chester, PA'         ,'M'),/*EMPLOYEE*/
('Owen'      ,'Nicholls'  ,'7005','EMPLOYEE','8AY98DHzsywfsGeA','2001-01-01','photo_id?=7005','owenlls@gmail.com'           ,'www.owen.com'           ,'Bachelor' ,'911 Ann Dr. Clover, SC'                       ,'M'),/*EMPLOYEE*/

/*TEACHER*/
('Alfie'     ,'Robinson'  ,'1007','TEACHER' ,'s8q9fkwqN3cdUnsm',NULL        ,'photo_id?=1007','alfson@gmail.com'            ,NULL                     ,'Doctorate','81 Studebaker Drive Wadsworth, OH'            ,'F'),/*TEACHER*/
('Ava'       ,'Sandoval'  ,'2001','TEACHER' ,'TCfdpt8f7vKTesNR','1955-12-23','photo_id?=2001','avaval@gmail.com'            ,NULL                     ,'Doctorate','8764 Pacific Street Augusta, GA'              ,'F'),/*TEACHER*/
('Melissa'   ,'Haynes'    ,'3005','TEACHER' ,'6HFGxWzTApECsXP2','1993-04-05','photo_id?=3005','melissahaynes@gmail.com'     ,NULL                     ,'Doctorate','7565 Fairview Court Irwin, PA'                ,'F'),/*TEACHER*/
('Chantelle' ,'Nicholls'  ,'4001','TEACHER' ,'9c8mTdcAXYXFHTp8','1983-10-11','photo_id?=4001','chantelholls@gmail.com'      ,NULL                     ,'Master'   ,'8176 North Ocean LaneLa Porte, IN'            ,'F'),/*TEACHER*/
('Muhammad'  ,'Goddard'   ,'4002','TEACHER' ,'DnxmaYHsgvhdPD4s','1986-12-18','photo_id?=4002','muhammadgoddard@gmail.com'   ,'www.muhammadgoddard.com','Doctorate','788 Border Street Reno, NV'                   ,'M'),/*TEACHER*/
('Abraham'   ,'Hart'      ,'4007','TEACHER' ,'DcUt6d9pzRL5gXpC','2000-02-13','photo_id?=4007','hart@gmail.com'              ,NULL                     ,'Master'   ,'8246 Coffee St. Lanham, MD'                   ,'M'),/*TEACHER*/

/*STUDENT*/
('Owain'     ,'Welch'     ,'2003','STUDENT' ,'Ne9YdCsdCV5nPG2Y','1952-04-04','photo_id?=2003','owalch@gmail.com'            ,'www.owainwelch.com'     ,'Bachelor' ,'25 Gartner St. Chillicothe, OH'               ,'M'),/*STUDENT*/
('Zoya'      ,'Ball'      ,'2004','STUDENT' ,'37gf9PtfhSckcx5V',NULL        ,NULL            ,'travisball@gmail.com'        ,NULL                     ,'Bachelor' ,'639 Deerfield Drive Whitehall, PA'            ,'F'),/*STUDENT*/
('Eleanor'   ,'Cohen'     ,'3001','STUDENT' ,'Btc6HUKPFQPQ8hdq',NULL        ,'photo_id?=3001','eleanohen@gmail.com'         ,'www.eleanor.com'        ,'Doctorate','40 South Arch Street Mount Holly, NJ'         ,'F'),/*STUDENT*/
('Mary'      ,'Hughes'    ,'3002','STUDENT' ,'kkxTjhGa5Pd9y8cs','1955-04-03','photo_id?=3002','maryhes@gmail.com'           ,NULL                     ,'Bachelor' ,'8993 Rockledge Drive Champaign, IL'           ,'F'),/*STUDENT*/
('Timothy'   ,'Perry'     ,'3003','STUDENT' ,'xKQjULuGU6TTGk3j','1995-11-27','photo_id?=3003','timoperry@gmail.com'         ,NULL                     ,'Bachelor' ,'162 Water Avenue Cary, NC'                    ,'M'),/*STUDENT*/
('Zoya'      ,'Morton'    ,'3007','STUDENT' ,'S3pghZj34qtQX4AW','1970-05-09','photo_id?=3007','zomorton@gmail.com'          ,NULL                     ,'Bachelor' ,'7893 Del Monte Ave. Lithonia, GA'             ,'F'),/*STUDENT*/
('Darcie'    ,'Warren'    ,'3008','STUDENT' ,'QfaCpZXXLV3vG7aB',NULL        ,'photo_id?=3008','darciewarren@gmail.com'      ,NULL                     ,'Bachelor' ,'59 E. Brook Dr. Portland, ME'                 ,'F'),/*STUDENT*/
('Sara'      ,'Armstrong' ,'5001','STUDENT' ,'WbuqDZc2dsYxjJPF','1996-03-24','photo_id?=5001','armstrong@gmail.com'         ,NULL                     ,'Master'   ,'7638 Front Street Stone Mountain, GA'         ,'M'),/*STUDENT*/
('Hussain'   ,'Love'      ,'5007','STUDENT' ,'UbUQUkJcKB7N6FWX','2000-06-05','photo_id?=5007','love@gmail.com'              ,NULL                     ,'Master'   ,'141 Oklahoma Ave. Bolingbrook, IL'            ,'M'),/*STUDENT*/
('Jasmin'    ,NULL        ,'6001','STUDENT' ,'pnqQR4nKw7Lbnzxe','1990-07-21','photo_id?=6001','rees@gmail.com'              ,NULL                     ,'Master'   ,'8196 West Sage St. Burke, VA'                 ,'F'),/*STUDENT*/
('Xander'    ,'Wood'      ,'6006','STUDENT' ,'SaFv8teJaZFAywf9','2000-06-05','photo_id?=6006','wood@gmail.com'              ,NULL                     ,'Bachelor' ,'59 Pennington Ave. Newtown, PA'               ,'M'),/*STUDENT*/
('Carrie'    ,'Sandoval'  ,'6007','STUDENT' ,'vVgfa2bPMFf3TgaU','1994-07-19','photo_id?=6007','sandoval@gmail.com'          ,NULL                     ,'Bachelor' ,'8582 Brickyard Road Delray Beach, FL'         ,'F'),/*STUDENT*/
('Josh'      ,NULL        ,'6008','STUDENT' ,'QnN5bY9FJBFSw45Z','1993-10-09','photo_id?=6008','carr@gmail.com'              ,'www.justjosh.com'       ,'Bachelor' ,'7846 Thorne Court Toledo, OH'                 ,'M'),/*STUDENT*/
('Elsie'     ,'Russell'   ,'6009','STUDENT' ,'HygG6FT6HPBswh6r',NULL        ,'photo_id?=6009','russell@gmail.com'           ,NULL                     ,'Bachelor' ,'37 Temple Dr. Port Charlotte, FL'             ,'F'),/*STUDENT*/
('Rupert'    ,'Cohen'     ,'7000','STUDENT' ,'QPxuTYnxNdjeaH4u',NULL        ,'photo_id?=7000','cohen@gmail.com'             ,NULL                     ,'Bachelor' ,'8425 Pin Oak St. Ephrata, PA'                 ,'M'),/*STUDENT*/
('Liberty'   ,'Hughes'    ,'7001','STUDENT' ,'mVAkYV9Nuapy8UPC','1992-11-09','photo_id?=7001','hughes@gmail.com'            ,NULL                     ,'Bachelor' ,'9093 Smoky Hollow Rd. Oak Creek, WI'          ,'F'),/*STUDENT*/
('Elizabeth' ,'Taylor '   ,'7006','STUDENT' ,'ajwhfbakwjfakwau',NULL        ,'photo_id?=7006','taylor@gmail.com'            ,NULL                     ,'Bachelor' ,'37 Temple Dr. Port Charlotte, FL'             ,'F'),/*STUDENT*/
('Rupper'    ,'Bird'      ,'7007','STUDENT' ,'akwndaiwndaoiwoi',NULL        ,'photo_id?=7007','bird@gmail.com'              ,NULL                     ,'Bachelor' ,'8425 Pin Oak St. Ephrata, PA'                 ,'M'),/*STUDENT*/
('Lycan'     ,'George'    ,'7008','STUDENT' ,'madwsonOISNIPDWN','1992-10-09','photo_id?=7008','lycangeorge@gmail.com'       ,NULL                     ,'Bachelor' ,'9093 Smoky Hollow Rd. Oak Creek, WI'          ,'F'),/*STUDENT*/

/*ORGANIZATION*/
('Facebook'                  ,NULL,'9900','CORPORATION','QXLcjUNp9xBWJ55h',NULL,'photo_id?=9901','facebook@gmail.com'       ,'www.facebook.com'       ,NULL       ,'Menlo Park, California, United States'        ,NULL),/*COMPANY*/
('Amazon'                    ,NULL,'9910','CORPORATION','KD3hQqyeB8GmqHyh',NULL,'photo_id?=9902','amazon@gmail.com'         ,'www.amazon.com'         ,NULL       ,'Seattle, Washington, United States'           ,NULL),/*COMPANY*/
('Hepsiburada'               ,NULL,'9920','CORPORATION','krU3NAKZFhF6Pv3b',NULL,'photo_id?=9903','hepsiburada@gmail.com'    ,'www.hepsiburada.com'    ,NULL       ,'Trump Towers, İstanbul, Türkiye'              ,NULL),/*COMPANY*/
('Ege Üniversitesi'          ,NULL,'9930','UNIVERSITY' ,'YNpcP3sZPtMfBvFF',NULL,'photo_id?=9904','ege@gmail.com'            ,'www.ege.edu.tr'         ,NULL       ,'Kazımdirik Mahallesi, Bornova, İZMİR'         ,NULL),/*UNIVERSITY*/
('Dokuz Eylül Üniversitesi'  ,NULL,'9940','UNIVERSITY' ,'T2jzL8d2ppVsMzcA',NULL,'photo_id?=9905','dokuzeylul@gmail.com'     ,'www.deu.edu.tr'         ,NULL       ,'Alsancak Mah, Konak, İzmir'                   ,NULL),/*UNIVERSITY*/
('Yüksek Teknoloji Enstitüsü',NULL,'9950','UNIVERSITY' ,'FDcM8fXtwbeSAvCn',NULL,'photo_id?=9906','iyte@gmail.com'           ,'www.iyte.edu.tr'        ,NULL       ,'Gülbahçe, Urla, İzmir'                        ,NULL);/*UNIVERSITY*/

/*----------------------------ORGANIZATION_ACCOUNTS: --------------------------------------- */
INSERT INTO ORGANIZATION_ACCOUNT
VALUES
('9900'),
('9910'),
('9920'),
('9930'),
('9940'),
('9950');

/*----------------------------5 OFFICES FOR 'FACEBOOK', 'AMAZON' AND 'HEPSIBURADA'. --------------------------------------- */
INSERT INTO OFFICE
VALUES
('9901','Facebook Headquarters'    ,'9900','Menlo Park, California, United States' ,'facebook@gmail.com'),
('9911','Amazon Headquarters'      ,'9910','Seattle, Washington, United States'    ,'amazon@gmail.com'),
('9912','Amazon LA'                ,'9910','Los Angeles, California, United States','amazon.la@gmail.com'),
('9921','Hepsiburada Genel Merkezi','9920','Trump Towers, İstanbul, Türkiye'       ,'hepsiburada@gmail.com'),
('9923','Hepsiburada İzmir'        ,'9920','Konak, Ankara'                         ,'hepsi.izmir@gmail.com');

/*---------------------------- 6 COURSE FOR 'Ege Üniversitesi', 'Dokuz Eylül Üniversitesi' AND 'Yüksek Teknoloji Enstitüsü' --------------------------------------- */
INSERT INTO COURSE
VALUES
('9931','Database Management','6'),
('9932','Automata Theory'    ,'4'),
('9941','Algoritma 1'        ,'5'),
('9942','Algoritma 2'        ,'5'),
('9951','Database Management','6'),
('9952','Algoritma 1'        ,'5');

/*---------------------------- UNIVERSITIES OFFER COURSES --------------------------------------- */
INSERT INTO OFFERS
VALUES
('9930','9931'),
('9930','9932'),
('9940','9941'),
('9940','9942'),
('9950','9951'),
('9950','9952');

/*---------------------------- ADMIN USERS --------------------------------------- */
INSERT INTO ADMIN_ACCOUNT
VALUES
('1001'),
('1002');

/*---------------------------- TEACHER USERS --------------------------------------- */
INSERT INTO TEACHER_ACCOUNT
VALUES
('1007','Data Science'),
('2001','Computer Science'),
('3005','Computer Science'),
('4001','Computer Science'),
('4002','Data Science'),
('4007','Computer Science');

/*---------------------------- BASIC USERS --------------------------------------- */
INSERT INTO BASIC_ACCOUNT
VALUES
('2002'),
('2006'),
('2009'),
('3004'),
('3006'),
('3009'),
('5002'),
('5003'),
('5004'),
('5006'),
('1003'),
('1005'),
('2005'),
('2007'),
('2008'),
('4003'),
('4004'),
('4005'),
('4006'),
('4008'),
('4009'),
('5005'),
('5008'),
('5009'),
('6002'),
('6003'),
('6004'),
('6005'),
('7002'),
('7003'),
('7004'),
('7005'),
('2003'),
('2004'),
('3001'),
('3002'),
('3003'),
('3007'),
('3008'),
('5001'),
('5007'),
('6001'),
('6006'),
('6007'),
('6008'),
('6009'),
('7000'),
('7001'),
('7006'),
('7007'),
('7008');

/*---------------------------- STUDENT USERS --------------------------------------- */
INSERT INTO STUDENT_ACCOUNT
VALUES
('1001','2003',4),
('1002','2004',3.8),
('1003','3001',3.4),
('1004','3002',3),
('1005','3003',2.9),
('1006','3007',2.5),
('1007','3008',3.4),
('2001','5001',3.6),
('2002','5007',2.2),
('2003','6001',1.8),
('2004','6006',2.6),
('2005','6007',3),
('2006','6008',2),
('2007','6009',3.9),
('3001','7000',3.5),
('3002','7001',2.6),
('3003','7006',3.8),
('3004','7007',2.8),
('3005','7008',3.1);

/*---------------------------- EMPLOYEE USERS --------------------------------------- */
INSERT INTO EMPLOYEE_ACCOUNT
VALUES
('1003','990101','9901'),
('1005','990102','9901'),
('2005','990103','9901'),
('2007','990104','9901'),
('2008','991101','9911'),
('4003','991102','9911'),
('4004','991103','9911'),
('4005','991201','9912'),
('4006','991202','9912'),
('4008','991203','9912'),
('4009','992101','9921'),
('5005','992102','9921'),
('5008','992103','9921'),
('5009','992104','9921'),
('6002','992105','9921'),
('6003','992106','9921'),
('6004','992107','9921'),
('6005','992108','9921'),
('7002','992301','9923'),
('7003','992302','9923'),
('7004','992303','9923'),
('7005','992304','9923');

/*---------------------------- TEACHERS TEACHES COURSES --------------------------------------- */
INSERT INTO TEACHES
VALUES
('1007','9931','Fall'),
('2001','9932','Fall'),
('3005','9941','Fall'),
('4001','9942','Spring'),
('4002','9951','Spring'),
('4007','9952','Fall');

/*---------------------------- STUDENTS ENROLL TO COURSES --------------------------------------- */
INSERT INTO ENROLLS
VALUES
('1001','9931',100,'Fall'),
('1001','9932',90,'Fall'),
('1002','9941',50,'Fall'),
('1003','9951',40,'Spring'),
('1003','9952',50,'Fall'),
('1004','9951',60,'Spring'),
('1004','9952',75,'Fall'),
('1005','9931',95,'Fall'),
('1005','9932',74,'Fall'),
('1006','9951',60,'Spring'),
('1006','9952',40,'Fall'),
('1007','9942',55,'Spring'),
('2001','9941',65,'Fall'),
('2001','9942',60,'Spring'),
('2002','9931',70,'Fall'),
('2003','9932',80,'Fall'),
('2004','9941',50,'Fall'),
('2004','9942',35,'Spring'),
('2005','9951',20,'Spring'),
('2005','9952',10,'Fall'),
('2006','9931',80,'Fall'),
('2006','9932',60,'Fall'),
('2007','9952',50,'Fall'),
('3001','9941',40,'Fall'),
('3001','9942',45,'Spring'),
('3002','9931',60,'Fall'),
('3002','9932',85,'Fall'),
('3003','9942',60,'Fall'),
('3004','9951',70,'Spring'),
('3005','9951',85,'Spring'),
('3005','9952',85,'Fall');

/*---------------------------- COURSES ASSIGN HOMEWORK --------------------------------------- */
INSERT INTO HOMEWORK
VALUES
('993110','9931','LinkedinMoodle Database'),
('993250','9932','Turing Machine'),
('994160','9941','İZSU Fatura Hesaplama'),
('994255','9942','DoublyLinkedList'),
('995175','9951','Kariyer.net Database'),
('995205','9952','TEDAŞ Fatura Hesaplama');

/*---------------------------- STUDENTS WORK ON HOMEWORK --------------------------------------- */
INSERT INTO WORKS_ON
VALUES
('1001','993110',50,'Fall'),
('1005','993110',60,'Fall'),
('2002','993110',70,'Fall'),
('2006','993110',85,'Fall'),
('3002','993110',75,'Fall'),
('1001','993250',90,'Fall'),
('1005','993250',100,'Fall'),
('2003','993250',50,'Fall'),
('2006','993250',65,'Fall'),
('3002','993250',70,'Fall'),
('1002','994160',40,'Fall'),
('2001','994160',20,'Fall'),
('2004','994160',10,'Fall'),
('3001','994160',50,'Fall'),
('1007','994255',40,'Spring'),
('2001','994255',45,'Spring'),
('2004','994255',65,'Spring'),
('3001','994255',70,'Spring'),
('3003','994255',75,'Spring'),
('1003','995175',85,'Spring'),
('1004','995175',90,'Spring'),
('1006','995175',95,'Spring'),
('2005','995175',75,'Spring'),
('3004','995175',45,'Spring'),
('3005','995175',35,'Spring'),
('1003','995205',20,'Fall'),
('1004','995205',25,'Fall'),
('1006','995205',90,'Fall'),
('2005','995205',65,'Fall'),
('2007','995205',55,'Fall'),
('3005','995205',55,'Fall');

/*---------------------------- PROJECTS INFORMATION --------------------------------------- */
INSERT INTO PROJECT
VALUES
('990120','META Research Project'),
('991125','Marketing Research Project'),
('991230','Amazon Prime Project'),
('992140','Pazar Araştırma Projesi'),
('992150','Ortaklık Kurma Projesi'),
('992160','Yatırım Projesi'),
('992310','Lokal Pazar Araştırma Projesi');

/*---------------------------- OFFICES CONTROL PROJECTS  --------------------------------------- */
INSERT INTO CONTROLS
VALUES
('9901','990120'),
('9911','991125'),
('9912','991230'),
('9921','992140'),
('9921','992150'),
('9921','992160'),
('9923','992310');

/*---------------------------- EXPERINCE INFORMATION --------------------------------------- */
INSERT INTO EXPERIENCE
VALUES
('0001','2000-07-16','2014-11-01','Teacher'),
('0002','2015-08-22','2018-07-06','Teacher'),
('0003','2001-02-01','2016-10-26','Teacher'),
('0004','2001-12-27','2008-02-02','Teacher'),
('0005','2002-05-12','2006-06-14','Teacher'),
('0006','2002-12-12','2012-07-30','Teacher'),
('0007','2006-11-01','2015-08-22','Teacher'),
('0008','2009-09-17','2022-12-12','Teacher'),
('0009','2010-03-29','2022-09-10','Employee'),
('0010','2012-07-29','2021-10-26','Employee'),
('0011','2014-01-03','2021-03-02','Employee'),
('0012','2014-03-03','2020-06-23','Employee'),
('0013','2019-02-10','2019-05-20','Employee'),
('0014','2013-12-19','2019-12-18','Employee'),
('0015','2007-05-31','2015-04-28','Employee'),
('0016','2008-02-02','2015-08-22','Employee'),
('0017','2008-04-20','2019-12-18','Employee'),
('0018','2009-01-13','2019-05-20','Employee'),
('0019','2009-02-24','2011-10-16','Employee'),
('0020','2009-06-25','2013-12-19','Employee'),
('0021','2012-07-30','2015-08-22','Employee'),
('0022','2014-05-31','2018-07-06','Employee'),
('0023','2007-05-31','2011-06-10','Employee'),
('0024','2004-06-29','2021-07-19','Employee'),
('0025','2005-07-10','2017-01-29','Employee');

/*---------------------------- EXPERINCES FOR USERS --------------------------------------- */
INSERT INTO HAS_EXPERIENCE
VALUES
('1007','0001'),
('1007','0002'),
('2001','0003'),
('3005','0004'),
('4001','0005'),
('4001','0006'),
('4002','0007'),
('4007','0008'),
('1003','0009'),
('1005','0010'),
('2007','0011'),
('4003','0012'),
('4005','0013'),
('4009','0014'),
('4009','0015'),
('5008','0016'),
('5008','0017'),
('6003','0018'),
('6004','0019'),
('6005','0020'),
('7002','0021'),
('7002','0022'),
('7003','0023'),
('7004','0024'),
('7004','0025');

/*---------------------------- LOCATIONS FOR EXPERIENCES --------------------------------------- */
INSERT INTO EXP_LOCATION
VALUES
('0001','9930'),
('0002','9940'),
('0003','9950'),
('0004','9930'),
('0005','9940'),
('0006','9950'),
('0007','9940'),
('0008','9930'),
('0009','9900'),
('0010','9910'),
('0011','9920'),
('0012','9910'),
('0013','9920'),
('0014','9900'),
('0015','9910'),
('0016','9920'),
('0017','9910'),
('0018','9920'),
('0019','9910'),
('0020','9900'),
('0021','9900'),
('0022','9910'),
('0023','9920'),
('0024','9900'),
('0025','9910');

/*---------------------------- USERS FOLLOW USERS --------------------------------------- */
INSERT INTO FOLLOWS
VALUES
('4006','1001'),
('3008','1001'),
('3009','1001'),
('7002','3004'),
('5008','3004'),
('4006','3004'),
('7007','5004'),
('5006','5004'),
('4002','5006'),
('7007','1003'),
('5001','4005'),
('5007','7008'),
('4005','4002'),
('5001','3003'),
('5009','7005'),
('3007','1003'),
('2005','2003'),
('7008','4001'),
('4009','5009'),
('7006','1005'),
('6002','3005'),
('4001','4008'),
('3005','7002'),
('6002','4009'),
('4008','1005'),
('3003','7003'),
('7003','7000'),
('2005','7005'),
('1007','7000'),
('5008','1007'),
('6009','4003'),
('4003','2004'),
('3002','6006'),
('5005','2005'),
('2003','6006'),
('2004','6003'),
('6005','4007'),
('6004','3001'),
('6003','7001'),
('6009','5005'),
('4007','6001'),
('6005','6004'),
('7001','7004'),
('2001','6003'),
('6008','6007'),
('7002','2001'),
('6001','6007'),
('3001','5007'),
('7004','6008'),
('7001','7002'),
('2003','9900'),
('2005','9900'),
('2004','9900'),
('2006','9900'),
('2004','9910'),
('2005','9910'),
('3002','9910'),
('3005','9910'),
('3003','9910'),
('3003','9920'),
('3004','9920'),
('3007','9920'),
('3007','9930'),
('3008','9930'),
('3009','9930'),
('4008','9930'),
('5008','9930'),
('5001','9930'),
('5002','9930'),
('5007','9940'),
('6001','9940'),
('6006','9940'),
('6007','9950'),
('6008','9950'),
('7001','9950');

/*---------------------------- USERS CONNETS TO USERS --------------------------------------- */
INSERT INTO CONNECTIONS
VALUES
('4006','1001'),
('3008','1001'),
('3009','1001'),
('7002','3004'),
('5008','3004'),
('4006','3004'),
('7007','5004'),
('5009','7005'),
('3007','1003'),
('2005','2003'),
('7008','4001'),
('4009','5009'),
('7006','1005'),
('6002','3005'),
('4001','4008'),
('3003','9920'),
('3004','9920'),
('3007','9920'),
('3007','9930'),
('3008','9930'),
('3009','9930'),
('5006','5004'),
('4002','5006'),
('7007','1003'),
('5001','4005'),
('5007','7008'),
('4005','4002'),
('5001','3003'),
('4008','9930'),
('6001','9940'),
('6006','9940'),
('6007','9950'),
('6008','9950'),
('7001','9950'),
('3005','7002'),
('6002','4009'),
('1007','7000'),
('5008','1007'),
('6009','4003'),
('4003','2004'),
('3002','6006'),
('5005','2005'),
('2003','6006'),
('2004','6003'),
('6005','4007'),
('6004','3001'),
('6003','7001'),
('6009','5005'),
('4007','6001'),
('6005','6004'),
('7001','7004'),
('2001','6003'),
('6008','6007'),
('7004','6008'),
('7001','7002'),
('2003','9900'),
('2005','9900'),
('2004','9900'),
('2006','9900'),
('2004','9910'),
('2005','9910'),
('3002','9910'),
('3005','9910'),
('3003','9910');

/*---------------------------- PUBLIC COURSE INFORMATION  --------------------------------------- */
INSERT INTO PUBLIC_COURSE
VALUES
('5501','Eğlenceli Yemek Kursu'             ,'Bornova, İzmir','2019-05-20','2019-08-20'),
('5502','Frontend İle Tanışalım'            ,'Konak, İzmir','2007-05-31','2007-09-20'),
('5503','Backend Nasıl Çalışır? '           ,'Konak, İzmir','2009-01-13','2009-05-10'),
('5504','Unity İle Bilgisayar Oyun Tasarımı','Bornova, İzmir','2021-07-19','2021-10-15'),
('5505','Python İle Yapay Zeka'             ,'Bornova, İzmir','2019-12-18','2020-02-10');

/*---------------------------- USERS ATTENDS TO PUBLIC COURSES --------------------------------------- */
INSERT INTO ATTENDS
VALUES
('2006','5501'),
('3003','5501'),
('2004','5501'),
('3006','5501'),
('2006','5502'),
('7000','5502'),
('3003','5502'),
('6007','5502'),
('5001','5502'),
('6007','5503'),
('2004','5503'),
('5001','5503'),
('3003','5504'),
('3006','5504'),
('7008','5504'),
('7007','5504'),
('6006','5505'),
('6008','5505'),
('6001','5505'),
('5007','5505'),
('5001','5505'),
('7000','5505'),
('7008','5505'),
('3003','5505');

/*---------------------------- USERS CREATE POSTS --------------------------------------- */
INSERT INTO POST
VALUES
('1001','1000','Lütfen sitenin kurallarına uyalım!','photo_id?=9901','2017-01-29',1),
('1007','1001','Bütün öğrencilerimize güzel bir eğitim öğretim yılı diliyorum.','photo_id?=9902','2014-01-03',3),
('2005','1002','Nesneye dayalı programlamadan kaldım.',NULL,'2022-01-28',5),
('2007','1003','Hepinizle çalışmaktan mutluluk duyuyorum.','photo_id?=9903','2008-02-02',4),
('5009','1004','Maaşımıza zam istiyoruz, enflasyon çok yüksek!!!','photo_id?=9904','2022-01-01',6);

/*---------------------------- USERS LIKE POST --------------------------------------- */
INSERT INTO LIKES_POST
VALUES
('6007','1000'),
('2005','1001'),
('3002','1001'),
('2002','1001'),
('2005','1002'),
('6007','1002'),
('4006','1002'),
('1007','1002'),
('1001','1002'),
('3005','1003'),
('3002','1003'),
('5002','1003'),
('7004','1003'),
('5002','1004'),
('2002','1004'),
('2005','1004'),
('7004','1004'),
('4006','1004'),
('3005','1004');

/*----------------------------   USERS COMMENT ON POSTS  --------------------------------------- */
INSERT INTO COMMENT
VALUES
('8801','1000','Teşekkürler admin kardeş.','2017-01-29',0),
('8802','1001','Dersler uzaktan fakat sınavlar yüz yüze. Neden ki?','2014-01-03',5),
('8803','1002','Merak etme, hepimiz kaldık. +1500','2022-01-28',10),
('8804','1003','Ben duymuyorum.','2008-02-02',2),
('8805','1004','Sen önce bi telefonunu çıkar da öyle konuş!','2022-01-01',0);

/*---------------------------- USERS LIKE COMMENT --------------------------------------- */
INSERT INTO LIKES_COMMENT
VALUES
('2003','8802'),
('2004','8802'),
('7007','8802'),
('6006','8802'),
('7006','8802'),
('2003','8803'),
('2004','8803'),
('3001','8803'),
('3002','8803'),
('3003','8803'),
('3007','8803'),
('3008','8803'),
('5001','8803'),
('5007','8803'),
('6001','8803'),
('6006','8804'),
('6007','8804');

/*---------------------------- WHICH COMMENT BELONGS TO WHICH USER --------------------------------------- */
INSERT INTO COMMENTS
VALUES
('3006','8801'),
('2001','8802'),
('5001','8803'),
('4004','8804'),
('3002','8805');

/*---------------------------- TAGS  --------------------------------------- */
INSERT INTO TAG
VALUES
('7771','#ADMIN',2),
('7772','#SCHOOL',5),
('7773','#BUSINESS',5);

/*---------------------------- TAGS BELONG TO POSTS  --------------------------------------- */
INSERT INTO BELONGS_TO
VALUES
('1000','7771'),
('1001','7772'),
('1002','7772'),
('1003','7773'),
('1004','7773');

/*---------------------------- USERS CAN FOLLOW TAGS --------------------------------------- */
INSERT INTO FOLLOWS_TAG
VALUES
('1001','7771','2019-12-18'),
('1002','7771','2020-06-23'),
('2003','7772','2015-04-28'),
('2004','7772','2021-10-26'),
('3001','7772','2021-07-19'),
('3008','7772','2019-05-20'),
('6009','7772','2009-09-17'),
('4004','7773','2006-06-14'),
('6002','7773','2019-02-10'),
('1005','7773','2017-01-29'),
('7003','7773','2021-03-02'),
('7005','7773','2014-05-31');