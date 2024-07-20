//Exercise 1:
String.prototype.filter = function(...bannedWords) {
    let str = this.toString();
    bannedWords.forEach(word => {
        const regex = new RegExp(`\\b${word}\\b`, 'gi');
        str = str.replace(regex, '');
    });
    return str.replace(/\s+/g, ' ').trim();
};

console.log("The original string 'This house is not nice!!!!.' and the bannedWords = ['not, '!']".filter('not', '!'));
console.log("This house is not nice!".filter('not', '!'));


//Exercise 2:
Array.prototype.bubbleSort = function() {
    let arr = this.slice();
    let len = arr.length;
    let swapped;

    do {
        swapped = false;
        for (let i = 1; i < len; i++) {
            if (arr[i - 1] > arr[i]) {
                [arr[i - 1], arr[i]] = [arr[i], arr[i - 1]];
                swapped = true;
            }
        }
        len--;
    } while (swapped);

    return arr;
};

console.log("The original array '6, 4, 0, 3, -2, 1'");
console.log([6, 4, 0, 3, -2, 1].bubbleSort());

//Exercise 3:
function Person(name) {
    this.name = name;
}

function Teacher(name) {
    Person.call(this, name);
}

Teacher.prototype = Object.create(Person.prototype);
Teacher.prototype.constructor = Teacher;

Teacher.prototype.teach = function(subject) {
    console.log(`${this.name} is teaching ${subject}.`);
};

const teacher1 = new Teacher('NVNT');
teacher1.teach('Maths');

function createPerson(name) {
    return {
        name,
    };
}

const TeacherPrototype = Object.create(createPerson(''));
TeacherPrototype.teach = function(subject) {
    console.log(`${this.name} is teaching ${subject}.`);
};

function createTeacher(name) {
    const teacher = Object.create(TeacherPrototype);
    teacher.name = name;
    return teacher;
}

const teacher2 = createTeacher('VT');
teacher2.teach('Sciences');

//Exercise 4:
const PersonPrototype = {
    greet: function() {
        console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
    },
    salute: function() {
        console.log("Hi!, good morning, good afternoon, good evening and good night!");
    }
};

const StudentPrototype = Object.create(PersonPrototype);
StudentPrototype.greet = function() {
    console.log(`Hey, my name is ${this.name} and I am studying ${this.major}.`);
};

function createStudent(name, age, major) {
    const student = Object.create(StudentPrototype);
    student.name = name;
    student.age = age;
    student.major = major;
    return student;
}

const ProfessorPrototype = Object.create(PersonPrototype);
ProfessorPrototype.greet = function() {
    console.log(`Hello, my name is ${this.name} and I am in the ${this.department} department.`);
};

function createProfessor(name, age, department) {
    const professor = Object.create(ProfessorPrototype);
    professor.name = name;
    professor.age = age;
    professor.department = department;
    return professor;
}

const student1 = createStudent('NVNT', 20, 'Maths');
student1.greet();
student1.salute();

const professor1 = createProfessor('VT', 50, 'Sciences');
professor1.greet();
professor1.salute();

function Person(name, age) {
    this.name = name;
    this.age = age;
}

Person.prototype.greet = function() {
    console.log(`Hi, my name is ${this.name} and I am ${this.age} years old.`);
};

Person.prototype.salute = function() {
    console.log("GM!, good morning, good afternoon, good evening and good night!");
};

function Student(name, age, major) {
    Person.call(this, name, age);
    this.major = major;
}

Student.prototype = Object.create(Person.prototype);
Student.prototype.constructor = Student;

Student.prototype.greet = function() {
    console.log(`Hi, my name is ${this.name} and I am studying ${this.major}.`);
};

function Professor(name, age, department) {
    Person.call(this, name, age);
    this.department = department;
}

Professor.prototype = Object.create(Person.prototype);
Professor.prototype.constructor = Professor;

Professor.prototype.greet = function() {
    console.log(`Good day, my name is ${this.name} and I am in the ${this.department} department.`);
};

const student2 = new Student('NVNT', 20, 'Computer Science');
student2.greet();
student2.salute();

const professor2 = new Professor('VT', 50, 'Physics');
professor2.greet();
professor2.salute();
