// 기명 함수
console.log(square(4));

function square(number) {
    return number * number;
}

// 익명 함수
// console.log(square2(4)); <---------- 호이스팅 영향을 받지 않음
let square2 = function (number) {
    return number * number;
};

console.log(square2(4));

// 즉시 실행 함수
console.log((function (number = 4) {
    return number * number;
})());