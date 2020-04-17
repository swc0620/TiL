package stack;

public class CheckingSymmetricLanguage {
	do{
		ch= string.getNextCharacter( );
		stack.push(ch);
	} while(chis not ‘$’)
	stack.pop( );
	do{
		if (string.noMoreCharacter( )) { ←의미는느낌으로받아들일것
			if (stack.isEmpty( )) {
				return true;
			} else{
				return false;
			}
		} else{
		if (stack.isEmpty( )) {
			return false;
		}
		stackTop = stack.pop( );
		ch= string.getNextCharacter( );
		}
	} while(ch== stackTop)
	return false;
}
