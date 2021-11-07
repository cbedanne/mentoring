package katas.compressList;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import model.Person;

class CompressListTest {

	@ParameterizedTest(name="{index} - {0}")
	@MethodSource("getObjectList")
	public <T> void testGenericList(TestCase<T> testCase) {

		Map<T, Long> compressedList=CompressList.compress(testCase.objectList);

		assertThat(compressedList.get(testCase.keyValue)).isEqualTo(testCase.expectedCount);

	}

	public static Stream<TestCase<?>> getObjectList() {

		Person person1=new Person("J",40,"B");
		Person person2=new Person("J",40,"B");
		return Stream.of(new TestCase<>(Arrays.asList(1, 1, 1, 2, 1, 2, 3, 5, 5, 5, 1, 1, 1, 1, 4), 1, 8L),
						 new TestCase<>(Arrays.asList("toto","titi","abc", "toto", "abc","abc"),"abc",3L),
						 new TestCase<>(Arrays.asList(person1,person1,person1,person2),person1,3L)
				);
	}

	private static class TestCase <T>{
		List<T> objectList;
		T keyValue;
		Long expectedCount;

		public TestCase(List<T> objectList, T keyValue, Long expectedCount) {
			this.objectList = objectList;
			this.keyValue = keyValue;
			this.expectedCount = expectedCount;
		}

		@Override
		public String toString(){
			return ("List of " + keyValue.getClass().getSimpleName());
		}
	}




}