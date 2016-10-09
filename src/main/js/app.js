const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		// this.state = {entities: []};
		this.state = {entities: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/entities'}).done(response => {
		// client({method: 'GET', path: '/api'}).done(response => {
			this.setState({entities: response.entity._embedded.entities});
		});
	}

	render() {
		return (
			<EntityList entities={this.state.entities}/>
		)
	}
}

class EntityList extends React.Component{
	render() {
		var entities = this.props.entities.map(entity =>
			<Entity key={entity._links.self.href} entity={entity}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>Content</th>
						<th>Favorite Number</th>
					</tr>
					{entities}
				</tbody>
			</table>
		)
	}
}

class Entity extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.entity.id}</td>
				<td>{this.props.entity.content}</td>
				<td>{this.props.entity.favoriteNumber}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
