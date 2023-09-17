# Use the base image as open JDK11
FROM openJDK:11

# Create the Argument in case you wish to pass jar file path at CLI 
# the default value is the target directory where jar gets generated 
ARG JAR_FILE=target/*.jar

# Copy the jar file 
Copy ${JAR_FILE} app.jar

# Execute the command java -jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
