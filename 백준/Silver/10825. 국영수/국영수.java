import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
	String name;
	int kor;
	int eng;
	int math;
	
	public Student() {}
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	@Override
	public int compareTo(Student o) {
		if (this.kor == o.kor) {
			if (this.eng == o.eng) {
				if (this.math == o.math) {
					//이름 사전정렬
					return this.name.compareTo(o.name);
				}
				return o.math - this.math;
			}
			return this.eng - o.eng;
		}
		
		return o.kor-this.kor;
	}
	
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Student> students = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			Student st = new Student();
			st.name = input[0];
			st.kor = Integer.parseInt(input[1]);
			st.eng = Integer.parseInt(input[2]);
			st.math = Integer.parseInt(input[3]);
			
			students.add(st);
		}
		
		//Comparable에 상속받고있거나
		//Comparator를 직접 생성해야 
		Collections.sort(students);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(students.get(i).name+"\n");
		}
		
		System.out.println(sb.toString());
		
		
	}

}
