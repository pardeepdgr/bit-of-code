title My Compiler
:start

echo c - Compile
echo r - Run
echo Press any other key to exit

set /p option=Option:
if %option% == c goto compile
if %option% == C goto compile
if %option% == r goto Run
if %option% == R goto Run

:compile
cls
javac *java
pause
goto start

:run
cls
java FirstClass
pause
exit
