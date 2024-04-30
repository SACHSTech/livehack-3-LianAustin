class Problem1 extends ConsoleProgram {

  public void run() {
    System.out.println("***** Student Account Registration *****");
    String strFirstName = readLine("Enter your first name: ");
    String strLastName = readLine("Enter your last name: ");
    String strStudentNumber = readLine("Enter your student number: ");
    String strUsername = readLine("Enter a new username: ");
    // The username validation and password is done in two seperate lines instead of being inside the print statements so it prints out the exception before printing out if the username is valid or not
    Boolean boolUsername = validateUsername(strUsername);
    String strPassword = createPassword(strFirstName, strLastName, strStudentNumber);
    System.out.println("\nValid username: " + boolUsername);
    System.out.println("Your password is: " + strPassword);
  }
  /**
   * Description: When given a username as a string parameter, returns true or false if the uesrname meets the following conditions:
   * The username consists of only letters and digits, it has at least one digit, and the length is greater then 7 characters.
   * @author: Austin L
   * @param strUsername the username to validate
   * @return true/false depending on if the username is valid or not
   */
  public static Boolean validateUsername(String strUsername){
    boolean boolIsValid = true;
    if(strUsername.length() < 8){
      boolIsValid = false;
    }
    for(int i = 0; i < strUsername.length(); i++){
      if(!Character.isLetterOrDigit(strUsername.charAt(i))){
        boolIsValid = false;
      }
    }
    if(boolIsValid){
      for(int i = 0; i < strUsername.length(); i++){
        if(Character.isDigit(strUsername.charAt(i))){
          boolIsValid = true;
          break;
        }
        else{
          boolIsValid = false;
        }
      }
    }
    return boolIsValid;
  }

  /**
   * Description: When given a first name, last name, and a 9 digit student number (as a string), returns a password
   * generated using the rule:
   * lowercase first 4 characters of last name + uppercase first initial of first name + middle 3 numbers of the student number
   * In addition, this method will throw an IllegalArgumentException error if any of its arguements are blank or if the student number is not 9 characters long
   * @author: Austin L
   * @param strFirstName The first name of the student
   * @param strLastName The last name of the student
   * @param strStudentNumber The nine digit student number of the student
   * @return the generated password
   */
  public static String createPassword(String strFirstName, String strLastName, String strStudentNumber){
    String strPassword = "";
    if(strFirstName.isBlank() || strLastName.isBlank() || strStudentNumber.isBlank()){
      throw new IllegalArgumentException("incorrect parameter(s)");
    }
    if(strStudentNumber.length() != 9){
      throw new IllegalArgumentException("incorrect parameter(s)");
    }
    // If the last name is less then 4, use the full last name
    if(strLastName.length() < 4){
      strPassword += strLastName.toLowerCase();
    }
    else{
      strPassword += strLastName.substring(0, 4).toLowerCase();
    }
    strPassword += Character.toUpperCase(strFirstName.charAt(0));
    strPassword += strStudentNumber.substring(3, 6);
    return strPassword;
  }
}