import sympy as sp

def main():
    # Solicitar al usuario dos valores
    value1 = float(input("Ingrese el primer valor: "))
    value2 = float(input("Ingrese el segundo valor: "))

    # Realizar operaciones
    suma = value1 + value2
    resta = value1 - value2
    multiplicacion = value1 * value2
    raiz_cuadrada = sp.sqrt(value1)
    integral = sp.integrate(value1 + value2, ('x', 0, 1))

    # Imprimir resultados
    print("Suma:", suma)
    print("Resta:", resta)
    print("Multiplicación:", multiplicacion)
    print("Raíz cuadrada de", value1, ":", raiz_cuadrada)
    print("Integral de", value1, "+", value2, ":", integral)

if __name__ == "__main__":
    main()
