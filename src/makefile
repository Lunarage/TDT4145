JFLAGS = -g
JC = javac
DOC = ../doc

.SUFFIXES: .java .class

SRCS := $(wildcard *.java)

.java.class:
	$(JC) $(JFLAGS) $*.java

default: $(SRCS:.java=.class)

doc:
	javadoc -version -author -d $(DOC) $(SRCS)

clean:
	$(RM) *.class

run:
	java Main
