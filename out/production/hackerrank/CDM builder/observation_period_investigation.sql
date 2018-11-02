-- OBSERVATION_PERIOD
-- grouping consecutive dates
-- eliminate source records if it is overlapping with another source record (SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend))
--

  |___1_____|
         |____2___|
		        |____3___|
				           |____4___|
						   

s1   t1  t2         s2
-----------------------------------------------------------------------------------------------
1  - 1   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail t2 WHERE dateadd(day, 32, t1.dtend) >= t2.dtstart AND dateadd(day, 32, t1.dtend) < t2.dtend)
1  - 2   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail t2 WHERE dateadd(day, 32, t1.dtend) >= t2.dtstart AND dateadd(day, 32, t1.dtend) < t2.dtend)
1  - 3   (1,2,3,4)  (1,2,3,4) 
1  - 4   (1,2,3,4)  (1,2,3,4)

2  - 1   (1,2,3,4)  (1,2,3,4) - eliminated by ON s1.dtstart <= dateadd(day, 32, t1.dtend)
2  - 2   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail t2 WHERE dateadd(day, 32, t1.dtend) >= t2.dtstart AND dateadd(day, 32, t1.dtend) < t2.dtend)
2  - 3   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend)) 
2  - 4   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend))

3  - 1   (1,2,3,4)  (1,2,3,4) - s1.dtstart <= dateadd(day, 32, t1.dtend)
3  - 2   (1,2,3,4)  (1,2,3,4) - s1.dtstart <= dateadd(day, 32, t1.dtend)
3  - 3   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend))
3  - 4   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend))

4  - 1   (1,2,3,4)  (1,2,3,4) - s1.dtstart <= dateadd(day, 32, t1.dtend)
4  - 2   (1,2,3,4)  (1,2,3,4) - s1.dtstart <= dateadd(day, 32, t1.dtend)
4  - 3   (1,2,3,4)  (1,2,3,4) - s1.dtstart <= dateadd(day, 32, t1.dtend)
4  - 4   (1,2,3,4)  (1,2,3,4)


  |___1_____|
      |_2_|
		      |____3___|

s1   t1  t2         s2
-----------------------------------------------------------------------------------------------
1  - 1   (1,2,3,4)  (1,2,3,4) - 
1  - 2   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend)) 
1  - 3   (1,2,3,4)  (1,2,3,4) 

2  - 1   (1,2,3,4)  (1,2,3,4) - eliminated by ON s1.dtstart <= dateadd(day, 32, t1.dtend)
2  - 2   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail t2 WHERE dateadd(day, 32, t1.dtend) >= t2.dtstart AND dateadd(day, 32, t1.dtend) < t2.dtend)
2  - 3   (1,2,3,4)  (1,2,3,4) - eliminated by (SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend)) 

3  - 1   (1,2,3,4)  (1,2,3,4) - s1.dtstart <= dateadd(day, 32, t1.dtend)
3  - 2   (1,2,3,4)  (1,2,3,4) - s1.dtstart <= dateadd(day, 32, t1.dtend)
3  - 3   (1,2,3,4)  (1,2,3,4) - 


SELECT s1.dtstart,
       MIN(t1.dtend) AS EndDate 
FROM native.temp_enrollment_detail s1 
INNER JOIN native.temp_enrollment_detail t1 ON s1.dtstart <= dateadd(day, 32, t1.dtend)
AND NOT EXISTS(SELECT * FROM native.temp_enrollment_detail t2 WHERE dateadd(day, 32, t1.dtend) >= t2.dtstart AND dateadd(day, 32, t1.dtend) < t2.dtend) 
WHERE NOT EXISTS(SELECT * FROM native.temp_enrollment_detail s2 WHERE s1.dtstart > s2.dtstart AND s1.dtstart <= dateadd(day, 32, s2.dtend))
GROUP BY s1.dtstart
ORDER BY s1.dtstart






