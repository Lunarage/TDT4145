JC = javac
JFLAGS = -g
DOCDIR = doc
SRCDIR = src
CLASSDIR = cls
CLASSPATH = .:$(SRCDIR)/
JARFILE = datdatbase.jar

SOURCES := $(wildcard $(SRCDIR)/*.java)
CLASSES := $(SOURCES:.java=.class)

%.class : %.java
	$(JC) $(JFLAGS) -classpath $(CLASSPATH) -d $(CLASSDIR) $<

default: $(CLASSES)

doc: $(CLASSES)
	javadoc -d $(DOCDIR) $(SOURCES)

jar: $(CLASSES)
	@echo "Manifest-Version: 1.0" > manifest.txt
	@echo "Class-path: /usr/share/java/mariadb-jdbc/mariadb-java-client.jar /usr/share/java/mysql-connector-java.jar" >> manifest.txt
	@echo "Main-Class: Main" >> manifest.txt
	@echo "" >> manifest.txt
	jar -v -c -m manifest.txt -f $(JARFILE) -C $(CLASSDIR) .

clean:
	$(RM) $(SRCDIR)/*.class
	$(RM) manifest.txt

run:
	java Main
