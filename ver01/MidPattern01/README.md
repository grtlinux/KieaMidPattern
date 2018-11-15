# KieaMidPattern
> project: MidPattern project  
> company: TAIN, Inc.  
> date: 2018.10.19  
> author: Kiea Seok Kang  
> comment: created MidPattern.jar with runjar  

-----
# compile and run

	DOS> java -jar MidPattern01.jar

	DOS> set JAVA_HOME=C:\tain\java\jdk1.7.0_79

	DOS> set PATH=%JAVA_HOME%\bin;%PATH%

	DOS> java -version
		java version "1.7.0_79"
		Java(TM) SE Runtime Environment (build 1.7.0_79-b15)
		Java HotSpot(TM) 64-Bit Server VM (build 24.79-b02, mixed mode)

	DOS> javac -cp ".;out/lib/*" -d out src/org/tain/runjar/*.java src/org/tain/test/*.java src/org/tain/utils/*.java  src/org/tain/midpattern/*.java

	DOS> jar cvfm MidPattern01.jar src/META-INF/MANIFEST.MF -C out .

	DOS> java -jar MidPattern01.jar


-----

## references
[]("") 
