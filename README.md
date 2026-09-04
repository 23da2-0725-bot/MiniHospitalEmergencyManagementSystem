# Mini Hospital Emergency Management System

## CIT300 - Data Structures and Algorithms

This project is a Mini Hospital Emergency Management System developed in Java.

The system demonstrates the practical use of different data structures to manage patient records, emergency patients, treatment history, and patient visit history.

## Data Structures Used

### 1. Binary Search Tree (BST)

The Binary Search Tree is used to store patient records using Patient ID as the key.

Operations:
- Insert a new patient
- Search for a patient using Patient ID
- Delete a patient
- In-order traversal to display patients in ascending order of Patient ID

Each patient record contains:
- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

### 2. Emergency Patient Queue

A Queue is used to manage patients waiting for emergency treatment.

Operations:
- Enqueue a patient
- Dequeue the next patient for treatment
- Display all patients currently waiting
- Handle an empty queue

The Queue follows the FIFO (First-In, First-Out) principle.

### 3. Treatment History Stack

A Stack is used to store completed treatment records.

Operations:
- Push a completed treatment record
- Pop the most recently completed treatment record
- Display treatment records
- Handle an empty stack

The Stack follows the LIFO (Last-In, First-Out) principle.

### 4. Patient Visit History - Singly Linked List

A Singly Linked List is used to maintain each patient's previous hospital visit history.

Operations:
- Add a new visit
- Remove a visit
- Search for a visit
- Display the patient's visit history

Each visit contains information such as:
- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

## Technologies Used

- Java
- Eclipse IDE
- Git
- GitHub

## Project Structure

MiniHospitalEmergencyManagementSystem
|
|-- src
|   |-- hospital
|       |-- Patient.java
|       |-- PatientNode.java
|       |-- PatientTree.java
|       |-- PatientBST.java
|       |-- EmergencyQueue.java
|       |-- Treatment.java
|       |-- TreatmentStack.java
|       |-- Visit.java
|       |-- VisitNode.java
|       |-- VisitLinkedList.java
|       |-- Main.java
|
|-- .gitignore
|-- .classpath
|-- .project
|-- README.md

## System Purpose

The purpose of this project is to demonstrate the implementation and practical use of fundamental data structures in a hospital emergency management system.

The system manages:
- Patient registration and records
- Emergency treatment queue
- Completed treatment history
- Patient previous visit history

## Learning Outcomes

Through this project, the implementation and practical application of the following data structures were demonstrated:

- Binary Search Tree
- Queue
- Stack
- Singly Linked List

The project also provided practical experience in Java programming, testing, Git, and GitHub version control.

## Author

Name: AM.AATHIF
SLTC ID: 23DA2-0725

CIT300 - Data Structures and Algorithms
Individual Mid Assignment