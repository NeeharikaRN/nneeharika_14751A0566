import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students == null)
			throw IllegalArgumentException;
		else
		{
			for(int i=0;i<students.length;i++)
			{
				this.students[i].setId(students[i].id);
				this.students[i].setFullName(students[i].fullName);
				this.students[i].setBirthDate(students[i].birthDate);
				this.students[i].setAvgMark(studnets[i].avgMark);
			}
		}
	}
	

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0||index >= this.students.length)
			throw IllegalArgumentException;
		
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(index<0||index>=this.students.length||student==null)
			throw IllegalArgumentException;
		
		this.students[index].id=student.id;
		this.students[index].fullName=student.fullName;
		this.students[index].birthDate=student.birthDate;
		this.students[index].avgMark=student.avgMark;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
			throw IllegalArgumentException;
		
		for(int i=this.students.length;i>=0;i++)
			this.students[i]=this.students[i-1];
		this.students[0]=student;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation 
		if(student==null)
			throw IllegalArgumentException;
		this.students[this.students.length]=student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(index<0||index>=this.students.length||student==null)
			throw IllegalArgumentException;
		for(int i=this.students.length;i>index;i++)
		{
			this.students[i]=this.students[i-1];
		}
		this.students[index]=student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0||index>=this.students.length||student==null)
			throw IllegalArgumentException;
		for(int i=index;i<(this.students.length-1);i++)
			this.students[i]=this.students[i+1];
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
			throw IllegalArgumentException;
		for(int i=0;i<this.students.length;i++)
			if(this.students[i]==student)
			{
				for(int j=i;j<(this.students.length);j++)
					this.students[j]=this.students[j+1];
			}
			else{
				System.out.println("Student does not exist");
				throw IllegalArgumentException;
			}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0 || index>this.students.length)
			throw IllegalArgumentException;
		StudentGroup s=new StudentGroup(index);
		for(int i=0;i<=index;i++)
		{
			s.students[i]=this.students[i];
		}
		this.students=s.students;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw IllegalArgumentException;
		for(int i=0;i<this.students.length;i++)
		{
			if(this.students==student)
			{
				i++;
				break;
			
			}
		}
		StudentGroup s=new StudentGroup(i);
		for(int j=0;(j<=i && j+i<this.students.length);j++)
		{
			s.students[j]=this.students[j+i];
		}
		this.students=s.students;
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index <0 || index>this.students.length)
			throw IllegalArgumentException;
		for(int i=0;(i<index && i+index < this.students.length);i++)
			this.students[i]=this.students[index+i];
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw IllegalArgumentException;
		for(int i=0;i<this.students.length;i++)
		{
			if(this.students==student)
			{
				i++;
				break;
			
			}
		}
		for(int j=0;(j<=i && j+i<this.students.length);j++)
		{
			this.students[j]=this.students[j+i];
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<this.students.length;i++)
		{
			int min;
			for(j=i+1;j<this.students.length;j++)
			{
				if(this.students[i].id>this.students[j].id)
				{
					min=this.students[i].id;
					this.students[i].id=this.students[j].id;
					this.students[j].id=min;
				}
			}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null)
			throw IllegalArgumentException;
		StudentGroup s= new StudentGroup(this.students.length);
		int j=0;
		for(i=0;i<this.students.length;i++)
		{
			if((date.compareTo(this.students[i].birthDate)<=0))
			{
				s.students[j]=this.students[i];
				j++;
			}
		}
		return s.students;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate==null || lastDate==null)
			throw IllegalArgumentException;
		int j=0;
		for(i=0;i<this.students.length;i++)
		{
			if((firstDate.compareTo(this.students[i].birthDate)>0) && (lastDate.compareTo(this.students[i].birthDate)<0))
			{
				s.students[j]=this.students[i];
				j++;
			}
		}
		return s.students;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
