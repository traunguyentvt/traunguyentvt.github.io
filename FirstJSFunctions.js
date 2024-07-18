function max(a, b) {
  if (a > b) {
    return a;
  }
  return b;
}

function maxOfThree(a, b, c) {
  if (a >= b && a >= c) {
    return a;
  } else if (b >= a && b >= c) {
    return b;
  }
  return c;
}

function isVowel(char) {
  char = char.toLowerCase();
  if (
    char === "a" ||
    char === "e" ||
    char === "i" ||
    char === "o" ||
    char === "u"
  ) {
    return true;
  }
  return false;
}

function sum(numbers) {
  let total = 0;
  for (let i = 0; i < numbers.length; i++) {
    total += numbers[i];
  }
  return total;
}

function multiply(numbers) {
  let total = 1;
  for (let i = 0; i < numbers.length; i++) {
    total *= numbers[i];
  }
  return total;
}

function reverse(str) {
  let reversedStr = "";
  for (let i = str.length - 1; i >= 0; i--) {
    reversedStr += str[i];
  }
  return reversedStr;
}

function findLongestWord(words) {
  let maxLength = 0;
  for (let i = 0; i < words.length; i++) {
    if (words[i].length > maxLength) {
      maxLength = words[i].length;
    }
  }
  return maxLength;
}

function filterLongWords(words, i) {
  let longWords = [];
  for (let j = 0; j < words.length; j++) {
    if (words[j].length > i) {
      longWords.push(words[j]);
    }
  }
  return longWords;
}

const a = [1, 3, 5, 3, 3];
const b = a.map(function (e) {
  return e * 10;
});

const c = a.filter(function (e) {
  return e === 3;
});

const d = a.reduce(function (prevValue, e) {
  return prevValue * e;
}, 1);

function myFunctionTest(expected, actual) {
  if (expected === actual) {
    return "TEST SUCCEEDED";
  } else {
    return "TEST FAILED";
  }
}

console.log(max(20, 10));
console.log(
  "Expected output of max(20, 10) is 20 and " + myFunctionTest(20, max(20, 10))
);
console.log(
  "Expected output of maxOfThree(5, 4, 44) is 44 and " +
    myFunctionTest(44, maxOfThree(5, 4, 44))
);
console.log(
  "Expected output of isVowel(o) is true and " +
    myFunctionTest(true, isVowel("o"))
);
console.log(
  "Expected output of sum([1, 2, 3, 4]) is 10 and " +
    myFunctionTest(10, sum([1, 2, 3, 4]))
);
console.log(
  "Expected output of multiply([1, 2, 3, 4]) is 24 and " +
    myFunctionTest(24, multiply([1, 2, 3, 4]))
);
console.log(
  'Expected output of reverse("abc") is cba and ' +
    myFunctionTest("cba", reverse("abc"))
);
console.log(
  'Expected output of findLongestWord(["apple", "banana", "cherry", "blueberry"]) is 9 and ' +
    myFunctionTest(
      9,
      findLongestWord(["apple", "banana", "cherry", "blueberry"])
    )
);
console.log(
  'Expected output of filterLongWords(["apple", "banana", "cherry", "blueberry"], 8)) is ["blueberry"] and ' +
    myFunctionTest(
      ["blueberry"],
      filterLongWords(["apple", "banana", "cherry", "blueberry"], 8)
    )
);
console.log(filterLongWords(["apple", "banana", "cherry", "blueberry"], 8));
