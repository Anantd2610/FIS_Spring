
public class CheckPersonEligibleForSelectiveService implements CheckPerson {

	@Override
	public boolean test(Person p) {
		// TODO Auto-generated method stub
		return p.gender == Sex.MALE &&
	            p.getAge() >= 18 &&
	            p.getAge() <= 25;
	}

}
