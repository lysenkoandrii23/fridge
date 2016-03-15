# fridge
Tricky algorithmic problem.
This project solves interesting mathematical task:
Consider we have the fridge with complicated lock on door which consist of 16 levers (4 rows with of 4 levers). All levers can be only in vertical or horizontal position. When you turn one lever all levers in the same row and column turn into opposite position.
The fridge can be opened only if all levers are in horizontal position.
The question is what levers will we turn to open the fridge?

My algorithm do this with double recursion without any additional objects in memory.
All magic is in method Main.solveFridge().
