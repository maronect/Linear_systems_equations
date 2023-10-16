mat = [[1.0, -1.0, -1.0, 0], [-0.3, -0.7, 0, -9.0], [0, 0.7, -0.5, 0]]

if _name_ == "_main_":
    for line in mat:
        print(line)
    print()

    cont = 1
    for k in range(0, len(mat)):
        if mat[k][k] == 0:
            for i in range(k + 1, len(mat)):
                if mat[i][k] != 0:
                    mat[k], mat[i] = mat[i], mat[k]
                    break

        div = mat[k][k]
        for i in range(0, len(mat[k])):
            mat[k][i] /= div

        for i in range(0, len(mat)):
            if k == i:
                continue

            sub = mat[i][k] / mat[k][k]
            for j in range(0, len(mat[k])):
                mat[i][j] -= mat[k][j]*sub

        dp = []
        print(f"interaçao {cont}:")
        for line in mat:
            prt = []
            for i in line:
                prt.append(round(i,2))
            print(prt)
            
        cont += 1
        print()