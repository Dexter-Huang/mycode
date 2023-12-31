package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

const N int = 100010

type Range struct {
	l, r int
}

var n int
var slot = make([]Range, N)
var scanner = bufio.NewScanner(os.Stdin)

func nextInt() int {
	scanner.Scan()
	num, _ := strconv.Atoi(scanner.Text())
	return num
}

func main() {
	scanner.Split(bufio.ScanWords)
	n = nextInt()
	for i := 0; i < n; i++ {
		slot[i].l = nextInt()
		slot[i].r = nextInt()
	}
	sort.Slice(slot[:n], func(i, j int) bool {
		if slot[i].r == slot[j].r {
			return slot[i].l < slot[j].l
		} else {
			return slot[i].r < slot[j].r
		}
	})
	res := 0
	var last int = -2e9
	for i := 0; i < n; i++ {
		if slot[i].l > last {
			res++
			last = slot[i].r
		}
	}
	fmt.Println(res)
}
