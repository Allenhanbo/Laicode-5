public class Solution {
  public List<String> permutations(String input) {
    // 3层 3个叉，2个叉，1个叉（remaining unused letters)
    //T:n!*n(n个字母排列是n！可能性，每个可能性遍历打印)
    //S：O(n)
    List<String> res = new ArrayList<>();
    if(input == null) {
      return res;
    }
    char[] array = input.toCharArray();
    helper(array, 0, res);
    return res;
  }
  private void helper(char[] array, int index, List<String> res) {
    if(index == array.length) {
      res.add(new String(array));
      return;
    }
    for(int i = index; i< array.length; i++) {
      swap(array, index, i);
      helper(array, index + 1, res);
      swap(array, index, i);
    }
  }
  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
