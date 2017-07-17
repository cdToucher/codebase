#!/bin/bash

# when use shell ,you specially pay an attention on space
# this is a simply tutorials for liunx shell


#basic use
echo "Hello World"

# declare a array
declare -a arr1=(1 2 3 4 5 6)
declare -a arr2=("a" "b" "c" "d" "qwe")

# how to use a array
echo ${arr1[1]}
echo ${arr1[*]}
echo ${arr2[2]}
echo ${arr2[*]}

# use a "if else"
if [ ${arr1[1]} != 1 ];then 
 echo 'true' 
else 
 echo 'false' 
fi

# use expr
let add=1+2
echo $add

# use out args
echo $1

# how to use "for in"
for I in ${arr2[*]} 
do echo $I 
done

for I in ${arr1[*]}
do echo $I
done

# functions 
func1()
{
 echo "this is func1."
}

func2()
{
 expr 1 + 2
}

func1
func2
