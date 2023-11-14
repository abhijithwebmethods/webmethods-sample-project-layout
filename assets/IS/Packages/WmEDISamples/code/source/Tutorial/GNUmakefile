include ../../../../../../build/makefile.include

# Set class directory and java command
CLASSES =${B2B_SERVER_ROOT}${SLASH}packages${SLASH}WmEDIsamples${SLASH}code${SLASH}classes
JAVA_CMD =${JAVAC}  -classpath "${CLASSES}${SEP}${CLASSPATH}" -d ${CLASSES}

all :  all_classes

all_classes : 
	${JAVA_CMD} *.java
