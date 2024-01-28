def countIndex(A, N):
	MAX = max(A)
	freq = [0 for i in range(MAX+1)]

	for i in range(N):
		if freq[A[i]] > 0:
			freq[A[i]] += 1
		else:
			freq[A[i]] = 1

	res = [0 for i in range(MAX+1)]

	for i in range(1, MAX + 1, 1):
		for j in range(i, MAX + 1, i):
		
			if (i == j):
				res[i] += (freq[j] - 1)
			else:
				res[i] += freq[j]
				res[j] += freq[i]

	for i in range(N):
		print(res[A[i]],end = " ")

if __name__ == '__main__':
	A = [1, 3, 4, 2, 6]
	N = len(A)

	countIndex(A, N)
	
