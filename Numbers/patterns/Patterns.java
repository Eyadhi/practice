package patterns;

public class Patterns {
	static void leftTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j <= n - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	static void rightTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j <= i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void twoTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < 2 * n; j++) {
				if (j <= n - i + 1) {
					System.out.print("*");
				} else if (j > n - i + 1 && j < n + i - 1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	static void rightdownTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j < i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	static void Butterfly(int n) {
		for (int i = 1; i <= 2 * n - 1; i++) {
			for (int j = 1; j <= 2 * n - 1; j++) {
				if ((i >= j && i + j <= n * 2) || (i + j >= n * 2 && j >= i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void downEquilateralTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n * 2 - 1; j++) {
				if (i == 1 || i == j || i + j == 2 * n) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void downEquilateralTriangle1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n * 2 - 1; j++) {
				if (j < i) {
					System.out.print(" ");
				} else if (j >= i && j < 2 * n - i + 1) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	static void rhombus1(int n) {
		// int n=7;
		for (int i = 0; i < n * 2 - 1; i++) {
			for (int j = 0; j < n; j++) {
				if (i < n && i + j >= n - 1 || i >= n && i - j <= n - 1)
					System.out.print("*");
				else
					System.out.print(" ");

			}
			System.out.println();
		}

		/*
		 * for(int i=1;i<=n*2-1;i++) {
		 * for(int j=1;j<=n*2-1;j++) {
		 * if((i+j<=n+1)||( i-j<=n-1 && j-i<=n-1 && i+j<=n*2-1)) {
		 * System.out.print("*");
		 * }
		 * else {
		 * System.out.print(" ");
		 * }
		 * }
		 * System.out.println();
		 * }
		 */
	}

	static void rhombus(int n) {
		for (int i = 1; i <= n * 2 - 1; i++) {
			for (int j = 1; j <= n * 2 - 1; j++) {
				if (i + j == n + 1 || i - j == n - 1 || j - i == n - 1 || i + j == n * 3 - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void EquilateralTriangle1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n * 2 - 1; j++) {
				if (j <= n - i) {
					System.out.print(" ");
				} else if (j >= n - i + 1 && j <= n + i - 1) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	static void EquilateralTriangle2(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n * 2 - 1; j++) {
				if (j < n - i + 1) {
					System.out.print(" ");
				} else if (j >= n - i + 1 && j <= n + i - 1) {
					if ((i + j) % 2 == 0) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	static void EquilateralTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n * 2 - 1; j++) {
				if (i == n || i + j == n + 1 || j - i == n - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void Pattern5(int n) {
		for (int i = 1; i <= n; i++) {
			int k = i;
			for (int j = 1; j <= i; j++) {
				System.out.print(k + " ");
				k = k + n - j;
			}
			System.out.println();
		}
	}

	static void Pattern6(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = (n - i) + 1; j <= n; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// EquilateralTriangle(4);
		// downEquilateralTriangle(4);
		// Pattern5(5);
		// rhombus(2);
		// Butterfly(4);
		// Pattern6(5);
		// leftTriangle(5);
		// rightdownTriangle(5);
		// rightTriangle(5);
		// twoTriangle(5);
		// rhombus1(4);
		// EquilateralTriangle1(5);
		// downEquilateralTriangle1(5);
		// EquilateralTriangle2(5);
	}

}
