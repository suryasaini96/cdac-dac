function palindrome(string){
    var s = 0;
    var e = string.length-1;
    var isPalindrome = true;
    while(s<e){
        if (string.charAt(s) != string.charAt(e)){
            isPalindrome = false;
            break;
        }
        s++;
        e--;
    }
    return isPalindrome;
}

function upper(string){
    return string.toUpperCase();
}

function search(arr){
    var count=0;
    arr.forEach(element => {
        if (element.slice(0,3) == "www")
            count++;
    });
    return count;
}

module.exports = {palindrome,upper,search};