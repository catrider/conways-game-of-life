var World = React.createClass({
  componentDidMount: function() {
    $.ajax({
      url: 'localhost:9000/nextGeneration',
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error("Call for next generation didn't work");
      }.bind(this)
    });
  },

  render: function() {
    var rowsOfCells = this.state.data.map(function (row) {
      var cells = row.map(function (cell) {
        return (
          <Cell alive={cell === 1}/>
        );
      });
      return (
        <tr>
          {cells}
        </tr>
      ); 
    });
    return (
      <table id="world">
        {cells}
      </table>
    );
  }
});

var Cell = React.createClass({
  render: function() {
    if( this.props.alive ) {
      return (
        <div>
          A
        </div>
      );
    } else {
      return (
        <td>A</td>
      );
    }
  }
});

React.render(
  <World />,
  document.getElementById('content')
);

