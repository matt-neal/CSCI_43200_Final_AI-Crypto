JAVAC=javac
sources = $(wildcard *.java)
classes = $(sources:.java=.class)
all: $(classes)
clean:
	$(RM) *.class
%.class: %.java
	$(JAVAC) $<