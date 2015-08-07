# Introduction #

Inception is the phase where we analyze whether or not it is worth to build our system.


# Overview #

We need to take a look at:
  * Actors and Use-Cases
  * Detail the important use-cases
  * Brief description of the other use-cases
Artifacts:
  * Use-Case Model
  * Supplementary Specification
  * Glossary
  * Risk List + Management Plan
  * Prototypes
  * Iteration Plan
  * Phase Plan + Software Development Plan
  * Development Case

# Actors and Use-Cases #
## Actors ##
  * User
  * Super User
  * Time
## Use-Cases ##
  1. Manage Things (General CRUD Use-Case)
    * Manage Users
    * Manage Housing
    * Manage Inhabitants
    * Manage Community
    * Manage Facilities
    * Manage Communication
    * ...
  1. Log in
  1. Establish Rent
  1. Terminate Rent
  1. Back-up Data
  1. Restore Data


# Brief Use-Cases #

## UC1 - Manage Things ##
Main Success Scenario:
  1. User requests system to add, update or remove a thing
  1. System asks for confirmation
  1. System applies the changes

## UC2 - Log in ##
Main Success Scenario:
  1. User types in his credentials
  1. System grants access


## UC3 - Establish Rent ##
Main Success Scenario:
  1. User Assigns a Propriety to one or more inhabitants
  1. System asks for permission and review of data
  1. System applies changes

## UC4 - Terminate Rent ##
Main Success Scenario:
  1. User remove a propriety from one or more inhabitants
  1. System asks for permission and review of data
  1. System applies changes

## UC5 - Backup Data ##
> User asks system to make a data backup, system asks for permission, system makes a backup on external medium.

## UC6 - Restore Data ##
> User asks system to make a data restore, system asks for permission, system checks and integrate the backed-up data with the existing data.


# Detailed Use-Cases #
The Use Case is detailed in fully dressed format
|Use case name|UC1 - Manage Users|
|:------------|:-----------------|
|Scope        |HASH -  Administration System for Housing|
|Level        |User Goal         |
|Primary actor|Power User        |
|Stakeholders and interests|Users needs to: 1. Manage Users by adding, updating or removing|
|Preconditions|System is Running and Power User authenticated|
|Success guarantee|User is saved into the system.|
|Main Success Scenario|# Power User enters User's information # System asks for review and confirmation # System saves the new user.|
|Extensions   |None              |
|Special Requirements|None              |
|Technology and Data Variations List|None              |
|Frequency of Occurrence|Every time a user needs to be managed|
|Miscellaneous|None              |