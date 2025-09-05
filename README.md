# BuilderCub - Coding Problems Collection

A comprehensive collection of coding problems and solutions organized by data structure and algorithm type.

## Project Structure

This project contains **655 Java files** organized into logical categories:

### Problem Categories

- **Arrays** (206 files) - Array manipulation, matrix operations, searching, sorting
- **Strings** (141 files) - String processing, pattern matching, palindromes
- **Trees** (116 files) - Binary trees, BST, tree traversals, tree algorithms
- **Linked Lists** (53 files) - List operations, reversals, cycle detection
- **Math** (49 files) - Mathematical algorithms, number theory, calculations
- **Graphs** (24 files) - Graph traversal, shortest paths, connectivity
- **Searching** (14 files) - Binary search, search algorithms
- **Miscellaneous** (14 files) - Various algorithmic problems
- **Backtracking** (13 files) - Recursive problem solving, permutations
- **Sorting** (12 files) - Sorting algorithms and related problems
- **Dynamic Programming** (8 files) - DP solutions, memoization
- **Greedy** (5 files) - Greedy algorithm implementations

## Sources Consolidated

Problems have been consolidated from multiple platforms:
- LeetCode
- GeeksForGeeks  
- AlgoExpert
- HackerRank
- Amazon Interview Questions
- HackerEarth
- Striver's SDE Sheet
- Grind 75
- Interview preparation materials

## Build & Run

### Prerequisites
- Java 17 or higher
- Gradle (wrapper included)

### Building the Project
```bash
./gradlew clean build
```

### Running Tests
```bash
./gradlew test
```

## Package Structure

All problems are organized under `com.buildercub` package with proper categorization:

```
problems/src/main/java/com/buildercub/
├── arrays/          # Array-based problems
├── strings/         # String manipulation problems  
├── trees/           # Tree data structure problems
├── linkedlists/     # Linked list problems
├── math/            # Mathematical problems
├── graphs/          # Graph algorithms
├── searching/       # Search algorithms
├── sorting/         # Sorting algorithms
├── backtracking/    # Backtracking solutions
├── dynamicprogramming/ # DP problems
├── greedy/          # Greedy algorithms
└── misc/            # Miscellaneous problems
```

## Key Features

- ✅ **Java-only codebase** - No Kotlin dependencies
- ✅ **Proper package organization** - Logical categorization by algorithm type
- ✅ **Duplicate removal** - Consolidated similar problems from different sources
- ✅ **Consistent naming** - Java naming conventions followed
- ✅ **Gradle build system** - Modern build configuration
- ✅ **GitHub Actions CI** - Automated build and test pipeline

## Contributing

When adding new problems:
1. Place them in the appropriate category package
2. Follow Java naming conventions
3. Ensure proper package declarations
4. Run `./gradlew build` to verify compilation

## CI/CD

The project includes GitHub Actions workflow that:
- Builds the project with Java 21
- Runs all tests
- Validates code compilation
- Triggers on push/PR to main branch
