class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] aux = new int[m + n];
    int l1 = 0;
    int l2 = 0;

    while (m > 0 && n > 0) {
      if (nums1[l1] < nums2[l2]) {
        aux[l1 + l2] = nums1[l1];
        l1++;
        m--;
      } else {
        aux[l1 + l2] = nums2[l2];
        l2++;
        n--;
      }
    }

    if (m != 0) {
      while (m > 0) {
        aux[l1 + l2] = nums1[l1];
        l1++;
        m--;
      }
    }

    if (n != 0) {
      while (n > 0) {
        aux[l1 + l2] = nums2[l2];
        l2++;
        n--;
      }
    }

    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = aux[i];
    }
  }
}
