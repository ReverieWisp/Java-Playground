package lamdasandpredicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

// Lamdas and predicates, while related, are not the same thing.
// A lambda can operate on its own with a few different structures,
// like consumer and biconsumer for different numbers of arguments.
//
// A predicate is, fundamentally, a function that returns true or
// false based on a single variable input.
//
// A lambda is, fundamentally, a function without a name. This is 
// also sometimes called an anonymous function.
public class Main
{
	@SuppressWarnings("unused")
	private class SomeNonLambaPredicate implements Predicate<String>
	{
		@Override
		public boolean test(String t) {
			// TODO Auto-generated method stub
			return false;
		}
	}
	
	// This is a function that takes another function (
	public static void DoThis5Times(Consumer<? super Integer> toDo)
	{
		for(int i = 0; i < 5; ++i)
		{
			// Call the function passed in, and give it 'i' as the argument.
			toDo.accept(i + 1);
		}
	}
	
	public static void main(String[] args)
	{
		List<String> toAlphabetize = new ArrayList<String>(Arrays.asList(new String[]{ new String("zucchini"), new String("banana"), new String("yam"), new String("apple"), new String("orange")}));
		toAlphabetize.sort((str1, str2) -> str1.compareTo(str2));
		
		
		// This calls the function and passes a lambda in.
		//DoThis5Times((num) -> { System.out.println("I got the number " + num); });
		//  ^ The function we are passing the lambda to
		//              ^ The argument for the lambda. Types for parameters don't have to be specified, but can be as normal if you want.
		//                  ^ The -> syntax is the defining symbol of the lambda, and says "The things on the left go to the scope of the function on the right".
		//                      ^ We need a { because we've started a new scope that's a function
		//                        ^ The body can be single or multi-lined, all code in here operates as expected,
		//                                                                        ^ You must close the scope as normal with }
		
		// Single-line lambda functions can be abbreviated and drop the { } plus the internal ;
		//DoThis5Times((num) -> System.out.println("Short! - " + num));
	}
}
