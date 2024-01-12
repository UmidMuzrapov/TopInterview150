class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    char[] rArr = new char[26];
    char[] mArr = new char[26];

    mapSpe(rArr, ransomNote);
    mapSpe(mArr, magazine);

    for (int i = 0; i < 26; i++) {
      if (mArr[i] < rArr[i]) return false;
    }

    return true;
  }

  private void mapSpe(char[] m, String str) {
    for (char ch : str.toCharArray()) {
      m[ch - 'a'] += 1;
    }
  }
}
