This is a simple molecular communication simulator created in Java for a mentorship project.

An environment is created in the main class with set height and width. 

Cells and molecules can be created in the environment. Currently, molecules can move around 
the environment in each simulation cycle randomly and the output shows the molecule's location.
Geographic location is based on a grid object created at the start of the program.

The molecules' movement is determined by differential equations based on three variables:
 1)  the exchange of input molecules from the extracellular to the intracellular environment,
 2)  the signal processing of output molecules through regulated gene expressions, and
 3)  the release of the output molecules from the intracellular to the extracellular environment.
