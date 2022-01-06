echo "This script will install and run PetGame on Termux"
pkg install git -y
pkg install openjdk-17 -y
cd
rm -rf PetGame/
git clone https://github.com/denzven/PetGame
cd PetGame/
javac src/*.java
clear
java -jar PetGame.jar
