package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

// N개의 보석
// K개의 가방
// 각 가방에는 최대 1개의 보석만 들어갈 수 있다.
var N, K int

// IntHeap은 heap.Interface를 구현하는 int 슬라이스
type IntHeap []int

// Len()은 힙의 길이를 반환
func (h IntHeap) Len() int { return len(h) }

// Less()는 h[i]가 h[j]보다 작은지 확인 (최소 힙의 경우)
// func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }

// Less()는 h[i]가 h[j]보다 작은지 확인 (최대 힙의 경우)
func (h IntHeap) Less(i, j int) bool { return h[i] > h[j] }

// Swap()은 h[i]와 h[j]의 위치를 변경
func (h IntHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

// Push()는 힙에 새로운 요소를 추가
func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

// Pop()은 힙에서 우선순위가 가장 높은 요소를 제거하고 반환
func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	item := old[n-1]
	*h = old[0 : n-1]
	return item
}

type Jewel struct {
	Weight int
	Value  int
}

func main() {
	reader := bufio.NewReader(os.Stdin)

	//첫째 줄에 N과 K를 읽어들이기
	input, _ := reader.ReadString('\n')
	input = strings.TrimSpace(input)
	parts := strings.Split(input, " ")
	N, _ := strconv.Atoi(parts[0])
	K, _ := strconv.Atoi(parts[1])

	//보석의 무게
	//보석의 가치
	var jewels []Jewel = make([]Jewel, N)

	//가방의 용량
	var bags []int = make([]int, K)

	//보석의 가치와 무게 입력
	for i := 0; i < N; i++ {
		var jewel Jewel
		input, _ = reader.ReadString('\n')
		input = strings.TrimSpace(input)
		parts = strings.Split(input, " ")
		W, _ := strconv.Atoi(parts[0])
		V, _ := strconv.Atoi(parts[1])

		jewel.Weight = W
		jewel.Value = V

		jewels[i] = jewel
	}

	//가방의 용량 입력
	for i := 0; i < K; i++ {
		var bag int
		input, _ = reader.ReadString('\n')
		input = strings.TrimSpace(input)
		bag, _ = strconv.Atoi(input)
		bags[i] = bag
	}

	//가방을 무게순으로 정렬
	//i번째와 j번째 index의 순서를 어떻게 정의할것이냐?
	sort.Slice(bags, func(i, j int) bool {
		return bags[i] < bags[j]
	})

	//보석을 무게순으로 정렬
	sort.Slice(jewels, func(i, j int) bool {
		return jewels[i].Weight < jewels[j].Weight
	})

	// //확인용
	// fmt.Println("=======logging=======")
	// fmt.Println(jewels)
	// fmt.Println(bags)
	pq := &IntHeap{}
	heap.Init(pq)
	result := 0

	//낮은 무게의 가방부터
	var i, j int = 0, 0
	for i < K {

		var bag int = bags[i]
		//낮은 무게의 보석이 들어갈 수 있는지를 확인해보고
		for j < N && jewels[j].Weight <= bag {
			//가능하다면 들어갈 후보목록에 해당 보석의 가치를 넣는다
			heap.Push(pq, jewels[j].Value)

			j++
		}

		// fmt.Print("현재 가방단계 : ")
		// fmt.Print(i)
		// fmt.Println("번째")

		// fmt.Println("==========for문 logging==========")
		// fmt.Println(pq)

		if pq.Len() > 0 {
			//Type Assertion 사용
			result += heap.Pop(pq).(int)
		}
		i++
	}

	fmt.Println(result)

}
