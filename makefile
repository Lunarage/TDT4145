JC = javac
JFLAGS = -g
DOCDIR = doc
SRCDIR = src
CLASSDIR = cls
CLASSPATH = .:$(SRCDIR)/
# JARFILE = datdatbase.jar

SOURCES := $(wildcard $(SRCDIR)/*.java)
CLASSES := $(SOURCES:$(SRCDIR)/%.java=$(CLASSDIR)/%.class)

$(CLASSDIR)/%.class : $(SRCDIR)/%.java
	$(JC) $(JFLAGS) -cp $(CLASSPATH) -d $(CLASSDIR) $<

all: $(CLASSES) doc jar

default: $(CLASSES)

doc: $(CLASSES)
	javadoc -d $(DOCDIR) $(SOURCES)

# Use eclipse or something to make the jar.
# jar: $(CLASSES)
# 	@echo "Manifest-Version: 1.0" > manifest.txt
# 	@echo "Class-path: mysql-connector-java.jar mariadb-java-client.jar /usr/share/java/mariadb-jdbc/mariadb-java-client.jar /usr/share/java/mysql-connector-java.jar" >> manifest.txt
# 	@echo "Main-Class: Main" >> manifest.txt
# 	@echo "" >> manifest.txt
# 	jar -v -c -m manifest.txt -f $(JARFILE) -C $(CLASSDIR) .

clean:
	$(RM) $(CLASSDIR)/*.class
	$(RM) manifest.txt
	$(RM) $(JARFILE)

run:
	java $(CLASSDIR) Main.class
