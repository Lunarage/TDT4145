JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

SRCS := $(wildcard *.java)

.java.class:
	$(JC) $(JFLAGS) $*.java

default: $(SRCS:.java=.class)

clean:
	$(RM) *.class

run:
	java Main
