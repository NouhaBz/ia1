# 8-Puzzle Solver

## Overview
This project implements an **8-Puzzle Solver** using **Java**. The 8-puzzle is a sliding puzzle that consists of a 3x3 grid with eight numbered tiles and one empty space. The goal is to move the tiles into the correct order using the empty space.

## Features
- Implements **A* (A-Star) Search Algorithm** to find the optimal solution.
- Uses **Manhattan Distance** as a heuristic to estimate the cost.
- Supports **initial state input** and solves the puzzle efficiently.
- Displays **step-by-step solution** from the initial state to the goal state.

## Installation
1. Ensure you have **Java 8 or later** installed.
2. Clone the repository or download the source code:
   ```bash
   git clone https://github.com/your-repo/8-puzzle-solver.git
   ```
3. Navigate to the project folder:
   ```bash
   cd 8-puzzle-solver
   ```
4. Compile the Java files:
   ```bash
   javac PuzzleSolver.java
   ```

## Usage
Run the program with:
```bash
java PuzzleSolver
```
### Example Input
The program will prompt for an initial state (3x3 grid representation):
```
1 2 3
4 5 6
7 8 0
```
Where `0` represents the empty space.

### Expected Output
The program will display the sequence of moves required to solve the puzzle.

## Algorithm
The solver uses the **A* search algorithm**, which combines:
- **g(n):** The actual cost from the start node to the current node.
- **h(n):** The heuristic cost (Manhattan Distance) from the current node to the goal.
- **f(n) = g(n) + h(n):** The estimated total cost.

This ensures the **shortest path** to the solution is found efficiently.

## Dependencies
- No external dependencies. The project runs on standard Java libraries.

## Contributing
Feel free to fork this repository and submit pull requests for improvements or optimizations.

## License
This project is licensed under the **MIT License**.
