echo "Beginning test execution...."

tagName=$1

echo $tagName

mvn clean
mvn compile
mvn test-compile
mvn install -Dcucumber.options="--tags @$tagName"
