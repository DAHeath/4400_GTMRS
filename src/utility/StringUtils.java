package utility;

public class StringUtils {

  public static String removeUnderscoresAndAddCaps(String in) {
    String spaced = in.replaceAll("_", " ");
    char[] chars = spaced.toCharArray();
    boolean found = false;
    for (int i = 0; i < chars.length; i++) {
      if (!found && Character.isLetter(chars[i])) {
        chars[i] = Character.toUpperCase(chars[i]);
        found = true;
      } else if (Character.isWhitespace(chars[i])) {
        found = false;
      }
    }
    return String.valueOf(chars);
  }

  public static String getAppropriateForm(String in) {
    String formTag = "";
    if (in.equals("password"))
      formTag = "password";
    else
      formTag = "text";
    return formTag;
  }
}
