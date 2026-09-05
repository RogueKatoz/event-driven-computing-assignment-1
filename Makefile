JUNIT = /usr/share/java/junit4.jar
HAMCREST = /usr/share/java/hamcrest-core.jar
CLASSPATH = .:$(JUNIT):$(HAMCREST)

MAIN = RegexEngine.java
TEST = RegexEngine_Test.java
TEST_CLASS = RegexEngine_Test

.PHONY: all compile test run clean

all: test

compile:
	javac -cp $(CLASSPATH) $(MAIN) $(TEST)

test: compile
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore $(TEST_CLASS)

run:
	javac $(MAIN)
	java RegexEngine

clean:
	rm -f *.class