import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StringPermutation {

	public static void main(String[] args) {
		List<String> permutations = generatePermutations("ABACA");
		print(permutations);
	}

	private static List<String> generatePermutations(String input) {
		char[] characteres = input.toCharArray();

		Map<Character, Integer> characterCounter = getCharacterCounter(characteres);
		char[] chars = getDistinctCharacters(characterCounter);
		int[] count = getDistinctCharactersCount(characterCounter);

		List<String> results = new ArrayList<String>();
		char[] result = new char[input.length()];
		permute(chars, count, result, 0, results);
		return results;
	}

	private static void permute(char[] chars, int[] count, char[] result,
			int level, List<String> results) {
		if (level == result.length) {
			results.add(new String(result));
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			if (count[i] == 0)
				continue;

			result[level] = chars[i];
			count[i]--;
			permute(chars, count, result, level + 1, results);
			count[i]++;
		}
	}

	private static Map<Character, Integer> getCharacterCounter(
			char[] characteres) {
		Map<Character, Integer> characterCounter = new HashMap<Character, Integer>();

		for (char character : characteres) {
			if (!characterCounter.containsKey(character)) {
				characterCounter.put(character, 1);
			} else {
				int exisitingCount = characterCounter.get(character);
				characterCounter.put(character, ++exisitingCount);
			}
		}
		return characterCounter;
	}

	private static char[] getDistinctCharacters(
			Map<Character, Integer> characterCounter) {
		char[] distinctCharacters = new char[characterCounter.size()];
		int index = 0;
		for (char character : characterCounter.keySet())
			distinctCharacters[index++] = character;
		return distinctCharacters;
	}

	private static int[] getDistinctCharactersCount(
			Map<Character, Integer> characterCounter) {
		int[] distinctCharactersCount = new int[characterCounter.size()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : characterCounter.entrySet())
			distinctCharactersCount[index++] = entry.getValue();
		return distinctCharactersCount;
	}

	private static void print(List<String> permutations) {
		for (String permutation : permutations)
			System.out.println(permutation);
	}

}