class Solution {
  public boolean isHappy(int n) {
    if (n == 1) return true;

    while (true && n > 6) {
      String str = String.valueOf(n);
      int x = 0;
      for (int i = 0; i < str.length(); i++) {
        x += (str.charAt(i) - '0') * (str.charAt(i) - '0');
      }

      if (x == 1) return true;
      else n = x;
    }

    return false;
  }
}
