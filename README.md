# Morfologik Stemmer CLI

This is a very simple missing CLI tool that uses
[Morfologik Polish Stemmer](https://github.com/morfologik/morfologik-stemming)
to stem tokens from stdin and print them to stdout.

### Input

Each line from stdin is treated as single token to stem.

### Output

The output is printed to stdout as a JSON list of serialized `WordData` class from Morfologik project.

### Example usage

```
$ ./morfologik-stemmer-cli
cześć
dobry
abstrakcyjnie

[[{"tag":"interj+subst:sg:acc:f+subst:sg:nom:f","word":"cześć","stem":"cześć"}],[{"tag":"adj:sg:acc:m3:pos+adj:sg:nom.voc:m1.m2.m3:pos+subst:sg:acc:m3+subst:sg:nom:m1+subst:sg:nom:m3+subst:sg:voc:m1+subst:sg:voc:m3","word":"dobry","stem":"dobry"}],[{"tag":"adv:pos","word":"abstrakcyjnie","stem":"abstrakcyjnie"}],[]]
```
