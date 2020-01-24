public int longest(String input) {
  // T: O(n) S: O(n)
  // i = slow, j = fast
  if(input == null || input.length() == 0) {
    return 0;
  }
  int i = 0;
  int distance = 0;
  int j = 0;
  Set<Character> set = new HashSet<>();
  while(j < input.length()) {
    //if it has the repeated characters,
    //remove chars and i start to move until no repeated characters
    if(set.contains(input.charAt(j))) {
      set.remove(input.charAt(i));
      i++;
    } else {
      set.add(input.charAt(j));
      j++;
      // global size
      distance = Math.max(distance, j - i);
    }
  }
  return distance;
}
}