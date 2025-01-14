a, b = map(int, input().split())
c = int(input())

tmp = b + c

if tmp >= 60:
    b = 0
    b += tmp % 60
    a += tmp // 60
    if a > 23:
        a = a - 24
    print(a, b)
else:
    print(a, tmp)