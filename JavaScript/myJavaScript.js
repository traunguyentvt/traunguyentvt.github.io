var a = 10;
function f () {
  console.log("x1: " + a);
  a = 20;
  console.log("x2: " + a);
  if (a > 0) {
    var a = 30;
    console.log("x3: " + a);
  }
  console.log("x4: " + a);
  var a = 40;
  var ff = function(x) {
      console.log("x5: " + a);
  };
  ff(50);
  console.log("x6: " + a);
}

f();
console.log("x7: " + a);