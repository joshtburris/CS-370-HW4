README
======

This package includes the following files:

|-- HW4.java [This is the file that will start and run the two producer and consumer threads]
|-- CircularBuffer.java [This is a circular queue that works like a linked list but connects the ends together]
|-- ConsumerProducer.java [This will run synchronized produce and consume methods that iterate 1,000,000 times]
|-- Makefile [This compiles your HW4.java, CircularBuffer.java, and ConsumerProducer.java programs to a runnable HW4 file]
|-- README.txt [This file]

To compile:
    	make
	OR
	make all

To run:
    	java HW4

For example:
    	java HW4

To clean the folder:
	make clean